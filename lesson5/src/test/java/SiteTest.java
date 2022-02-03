import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SiteTest {
    WebDriver chromeDriver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String URL = "https://imgur.com";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        chromeDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        actions = new Actions(chromeDriver);
        chromeDriver.get(URL);
        chromeDriver.manage().window().maximize();
    }

    @AfterEach
    void closeSite() {
        chromeDriver.quit();
    }

    @Test
    public void checks() throws InterruptedException {
        // проверка загрузки страницы по признаку наличия элемента с надписью "Sign in"
        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath("//a[text()='Sign in']"))));
        Assertions.assertEquals(1, chromeDriver.findElements(By.xpath("//a[text()='Sign in']")).size());
        chromeDriver.findElement(By.xpath("//a[text()='Sign in']")).click();

        // проверка открытия страницы авторизации по признаку наличия элемента с надписью "Sign In with"
        webDriverWait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath("//div[text()='Sign In with']"))));
        Assertions.assertEquals(1, chromeDriver.findElements(By.xpath("//div[text()='Sign In with']")).size());
        chromeDriver.findElement(By.id("username")).sendKeys("serzsv");
        chromeDriver.findElement(By.id("password")).sendKeys("qwerty123");

        // проверка наличия кнопки авторизации
        Assertions.assertEquals(1, chromeDriver.findElements(By.id("Imgur")).size());
        chromeDriver.findElement(By.id("Imgur")).click();

        // проверка наличия на странице меню профиля
        webDriverWait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath("//div[@class='Dropdown-title']/span[text()='serzsv']"))));
        Assertions.assertEquals(1, chromeDriver.findElements(By.xpath("//div[@class='Dropdown-title']/span[text()='serzsv']")).size());
        chromeDriver.findElement(By.xpath("//div[@class='Dropdown-title']")).click();

        // проверим наличие пункта меню "Images" в меню профиля
        webDriverWait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath("//div[@class='Dropdown-option-group']/a[@class='Dropdown-option' and text()='Images']"))));
        Assertions.assertEquals(1, chromeDriver.findElements(By.xpath("//div[@class='Dropdown-option-group']/a[@class='Dropdown-option' and text()='Images']")).size());
        chromeDriver.findElement(By.xpath("//div[@class='Dropdown-option-group']/a[@class='Dropdown-option' and text()='Images']")).click();
        Thread.sleep(3000);
    }

}
