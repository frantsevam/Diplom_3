package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;

    private static final By CONSTRUCTOR_BUTTON = By.xpath("//p[text()='Конструктор']"); //Докатор кнопки "Конструктор"

    private static final By LOGO_BUTTON = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']"); //Локатор логотипа "Stellar Burgers"

    private static final By LOG_OUT_BUTTON = By.xpath("//button[text()='Выход']"); //Локатор кнопки "Выход"

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
    }

    @Step("Клик по кнопке Выход")
    public void clickLogOutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(LOG_OUT_BUTTON));
        driver.findElement(LOG_OUT_BUTTON).click();
    }
}
