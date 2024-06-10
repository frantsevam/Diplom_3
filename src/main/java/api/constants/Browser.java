package api.constants;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    public static WebDriver getDriver() {
        WebDriver driver;
        String browserName = System.getProperty("browser");
        if (browserName == null) {
            browserName = "chrome";
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Ошибка запуска браузера: " + browserName);
        }
        driver.manage().window().maximize();
        return driver;
    }
}


