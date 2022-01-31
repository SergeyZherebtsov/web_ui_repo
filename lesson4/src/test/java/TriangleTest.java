import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger("TriangleTest.class");

    @BeforeAll
    static void beforeAll() {
        logger.info("log data");
        logger.trace("trace log data");
        logger.error("err log data");
    }

    @Test
    @DisplayName("AreaOfTriagle")
    public void triangleArea() throws Exception {
        Assertions.assertEquals("14,6969", String.format("%.4f", Triangle.getArea(5, 6, 7)));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,'0,0000'", "5,15,18,'32,6190'"})
    public void triangleAreas(int a, int b, int c, String result) throws Exception {
        Assertions.assertEquals(result, String.format("%.4f", Triangle.getArea(a, b, c)));
    }

    @Test
    public void oneSideLessThenZero() throws Exception {
        Assertions.assertThrows(TriangleExceptions.class, () ->Triangle.getArea(-5, 5, 5));
    }
}
