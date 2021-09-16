import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

        /*Вам нужно написать ui тесты на проверку работы функциональности входа в систему.
        Чеклиста для такой проверки у нас нет, но он может начинаться так:

        Действия:
        1. Открыть систему по адресу https://lmslite47vr.demo.mirapolis.ru/mira
        2. В поле для ввода логина ввести значение fominaelena
        3. В поле для ввода пароля ввести значение z0K6CTQR
        4. Нажать кнопку Войти
        Результат: Отображение страницы открываемой после успешного входа.
        …

        Требования:
        Реализовать нужно на языке Java. Версию можно использовать любую.
        Для сборки проекта можно использовать maven или gradle.
        Нужно использовать библиотеку selenium-api или selenide.

         */


public class RegistrationPage {
    private static WebDriver driver;

    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
        driver.findElement(By.xpath("//input[@name='user']")).sendKeys("fominaelena");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("z0K6CTQR");
        driver.findElement(By.xpath("//button[@id='button_submit_login_form']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                ("//div[@class='avatar-full-name']")));
        driver.findElement(By.xpath("//div[@class='avatar-full-name']")).click();
        Thread.sleep(5000);
        driver.quit();
    }

}
