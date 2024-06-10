package pom;

import api.user.UserRegistration;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static api.constants.ApiAndUrl.*;

public class RegistrationPage {
    private WebDriver driver;
    private static final By NAME_INPUT = By.xpath("//label[text()='Имя']//following-sibling::input"); //Поле воода имени
    private static final By EMAIL_INPUT = By.xpath("//label[text()='Email']//following-sibling::input"); //Поле ввода email
    private static final By PASSWORD_INPUT = By.xpath("//input[@type='password']"); //Поле ввода пароля
    private static final By REGISTER_BUTTON = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");  //Кнопка "Зарегистрироваться"
    private static final By LOGIN_BUTTON = By.xpath("//a[text()='Войти']"); //Кнопка "Войти"
    public static final By TEXT_ERROR = By.xpath(".//p[text()='Некорректный пароль']"); //Текст ошибки при некорректном вводе пароля

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открываем страницу - Регистрация")
    public RegistrationPage openRegisterPage() {
        driver.get(REGISTER_PAGE_URL);
        return this;
    }

    @Step("Заполнение поля Имя")
    public void setName(String name) {
        driver.findElement(NAME_INPUT).click();
        driver.findElement(NAME_INPUT).sendKeys(name);
    }

    @Step("Заполнение поля Email")
    public void setEmail(String email) {
        driver.findElement(EMAIL_INPUT).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Заполнение поля Пароль")
    public void setPassword(String password) {
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }
    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }

    @Step("Заполняем форму регистрации")
    public RegistrationPage fillingInTheRegistrationFields(UserRegistration userRegistration) {
        setName(userRegistration.getName());
        setEmail(userRegistration.getEmail());
        setPassword(userRegistration.getPassword());
        return this;
    }

    @Step("Получить текст ошибки некорректного пароля")
    public String getTextError() {
        driver.findElement(EMAIL_INPUT).click();
        return driver.findElement(TEXT_ERROR).getText();
    }

    @Step("Клик по кнопке Войти")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
