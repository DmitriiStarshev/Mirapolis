import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TaskTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
    }

    @Test
    void chekTitleCiteTest() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Авторизация"));

    }

    @Test
    void positiveRegistrationTest() {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
        driver.findElement(By.xpath("//input[@name='user']")).sendKeys("fominaelena");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("z0K6CTQR");
        driver.findElement(By.xpath("//button[@id='button_submit_login_form']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@class='avatar-full-name']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='avatar-full-name']")).isDisplayed());
    }

    @Test
    void negativeRegistrationTest() throws InterruptedException {
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
        driver.findElement(By.xpath("//button[@id='button_submit_login_form']")).click();
        JavascriptExecutor javascriptExecutor =(JavascriptExecutor) driver;
        driver.switchTo().alert().accept();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//input[@name='user']")).isDisplayed());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
