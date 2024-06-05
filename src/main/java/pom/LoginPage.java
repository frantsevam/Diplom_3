package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static api.constants.ApiAndUrl.*;

public class LoginPage {
    private WebDriver driver;
    private static final By LOG_IN_BUTTON = By.xpath(".//*[text()='Войти']");    //Локатор кнопки "Войти"
    private static final By EMAIL_INPUT = By.xpath(".//input[@name='name']"); //Локатор поля ввода email
    private static final By PASSWORD_INPUT = By.xpath(".//input[@name='Пароль']"); //Локатор поля ввода пароля

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы авторизации")
    public LoginPage openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
        (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        return this;
    }

    @Step("Заполнение формы авторизации")
    public void setLoginForm(String email, String password) {
        (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        driver.findElement(EMAIL_INPUT).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }
}