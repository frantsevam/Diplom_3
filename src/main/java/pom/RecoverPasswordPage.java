package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static api.constants.ApiAndUrl.*;

public class RecoverPasswordPage {
    private WebDriver driver;
    private static final By LOG_IN_BUTTON = By.xpath(".//*[text()='Войти']"); //Локатор для кнопки "Войти"

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открываем страницу восстановления пароля")
    public RecoverPasswordPage openRecoverPasswordPage() {
        driver.get(RECOVER_PASSWORD_PAGE_URL);
        (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe(RECOVER_PASSWORD_PAGE_URL));
        return this;
    }

    @Step("Клик по кнопке войти")
    public void clickLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }
}
