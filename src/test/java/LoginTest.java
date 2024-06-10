import org.junit.Assert;
import pom.*;
import api.user.UserRequests;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static api.constants.ApiAndUrl.LOGIN_PAGE_URL;

public class LoginTest extends BeforeAndAfter {

    @Test
    @DisplayName("Если пользователь неавторизован, отображается кнопка -Войти в аккаунт-")
    public void checkTextOnButtonCreateOrderUserWithoutAuthotizationTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPageMain();

        String buttonText = mainPage.getTextOrderButton();

        Assert.assertEquals("Кнопка не найдена!", "Войти в аккаунт", buttonText);
    }

    @Test
    @DisplayName("Если пользователь авторизован, отображается кнопка -Оформить заказ-")
    public void checkTextOnButtonCreateOrderUserWithAuthotizationTest() {
        UserRequests.createUser(userRegistration);

        MainPage mainPage = new MainPage(driver);
        mainPage.openPageMain();
        mainPage.clickOrderButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        String buttonText = mainPage.getTextOrderButton();

        Assert.assertEquals("Кнопка не найдена!", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Через кнопку -Войти в аккаунт- можно авторизоваться")
    public void checkSuccessLoginFromMainPageButtonLogInAccountTest() {
        UserRequests.createUser(userRegistration);

        MainPage mainPage = new MainPage(driver);
        mainPage.openPageMain();
        mainPage.clickOrderButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        String buttonText = mainPage.getTextOrderButton();

        Assert.assertEquals("Кнопка не найдена!", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Через кнопку -Личный кабинет- можно авторизоваться")
    public void checkSuccessLoginFromMainPageButtonAccountTest() {
        UserRequests.createUser(userRegistration);

        MainPage mainPage = new MainPage(driver);
        mainPage.openPageMain();
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        String buttonText = mainPage.getTextOrderButton();

        Assert.assertEquals("Кнопка не найдена!", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Через кнопку -Войти- в форме регистрации можно авторизоваться")
    public void checkSuccessLoginFromRegistrationPageButtonLogInTest() {
        UserRequests.createUser(userRegistration);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegisterPage();
        registrationPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        MainPage mainPage = new MainPage(driver);
        String buttonText = mainPage.getTextOrderButton();

        Assert.assertEquals("Кнопка не найдена!", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Успешная авторизация пользователя через форму восстановления пароля")
    public void checkSuccessLoginFromRecoverPasswordPageButtonLogInTest() {
        UserRequests.createUser(userRegistration);

        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.openRecoverPasswordPage();
        recoverPasswordPage.clickLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        MainPage mainPage = new MainPage(driver);
        String buttonText = mainPage.getTextOrderButton();

        Assert.assertEquals("Кнопка не найдена!", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Авторизация с корректными логином и паролем = открытие главно страницы")
    public void checkSuccessLoginWithCorrectEmailAndCorrectPasswordTest() {
        UserRequests.createUser(userRegistration);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        MainPage mainPage = new MainPage(driver);
        String buttonText = mainPage.getTextOrderButton();

        Assert.assertEquals("Кнопка не найдена!", "Оформить заказ", buttonText);
    }

    @Test
    @DisplayName("Авторизация с некорректными логином и паролем = страница не меняется")
    public void checkLoginWithIncorrectEmailAndIncorrectPassword() {
        UserRequests.createUser(userRegistration);

        String newEmail = "abracodabra" + userRegistration.getEmail();
        String newPassword = "abracodabra" + userRegistration.getPassword();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.setLoginForm(newEmail, newPassword);
        loginPage.clickLogInButton();

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Авторизация с некорректным паролем завершится ошибкой")
    public void checkLoginWithCorrectEmailAndIncorrectPassword() {
        UserRequests.createUser(userRegistration);

        String newPassword = "abracodabra" + userRegistration.getPassword();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.setLoginForm(userRegistration.getEmail(), newPassword);
        loginPage.clickLogInButton();

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Авторизация с некорректным email завершится ошибкой")
    public void checkLoginWithIncorrectEmailAndCorrectPassword() {
        UserRequests.createUser(userRegistration);

        String newEmail = "abracodabra" + userRegistration.getEmail();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.setLoginForm(newEmail, userRegistration.getPassword());
        loginPage.clickLogInButton();

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Если незаполнить ни одно поле авторизации - авторизация завершится ошибкой")
    public void checkLoginWithNoEmailAndNoPassword() {
        UserRequests.createUser(userRegistration);

        String newEmail = "";
        String newPassword = "";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.setLoginForm(newEmail, newPassword);
        loginPage.clickLogInButton();

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", LOGIN_PAGE_URL, driver.getCurrentUrl());
    }
}