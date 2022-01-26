package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Lesson 3
 * Zherebtsov SV
 */
public class SeleniumStart
{
    public static void main( String[] args ) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://imgur.com");
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));

 //       Thread.sleep(3000);
 //       chromeDriver.findElement(By.xpath("//a[text()='Sign in']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath("//a[text()='Sign in']")))).click();

        chromeDriver.findElement(By.id("username")).sendKeys("serzsv");
        chromeDriver.findElement(By.id("password")).sendKeys("qwerty123");
        Thread.sleep(1000);
        chromeDriver.findElement(By.id("Imgur")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("//div[@class='Dropdown-title']")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("//div[@class='Dropdown-option-group']/a[@class='Dropdown-option' and text()='Images']")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("//div[@id='view']//div[contains(text(),'All Images')]")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("//div[@id='view']//div[@data-value='new']")).click();
        chromeDriver.findElement(By.id("album-title")).sendKeys("Test_album");
        chromeDriver.findElement(By.id("album-description")).sendKeys("GB. Lesson 3");
        chromeDriver.findElement(By.xpath("//div[@id='create-album-form']//input[@class='button-medium' and @value='Save']")).click();

    }
}
