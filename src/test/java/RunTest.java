import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class RunTest {

    private WebDriver driver;
    private WebDriverWait wait;
    // arrange
    private By searchLocator = By.id("text");
    private By logoLocator = By.className("home-logo__default");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // Позитивный тест наличия строки поиска и определение количества лого сайта
    @Test
    public void testMainPagePositive() {
        // act
        driver.navigate().to("https://yandex.ru/");
        // assert
        Assert.assertTrue("Элемент не найден", driver.findElement(searchLocator).isDisplayed());
        Assert.assertEquals("Количество элементов не совпадает", 1,
                driver.findElements(logoLocator).size());
    }

    // Негативный тест определение количества лого сайта
    @Test
    public void testMainPageNegative() {
        // act
        driver.navigate().to("https://yandex.ru/");
        // assert
        Assert.assertEquals("Количество элементов не совпадает", 2,
                driver.findElements(logoLocator).size());
    }
}
