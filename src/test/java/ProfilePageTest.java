import api.user.UserRequests;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.*;

import java.time.Duration;

import static api.constants.ApiAndUrl.*;


public class ProfilePageTest extends BeforeAndAfter {

    @Test
    @DisplayName("Если пользователь не авторизован, при клике на кнопку -Личный кабинет- происходит переход на страницу Авторизации")
    public void checkUserNoAuthClickProfileButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPageMain();
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Если пользователь авторизован, при клике на кнопку -Личный кабинет- происходит переход на страницу профиля")
    public void checkUserWithAuthClickProfileButton() {
        UserRequests.createUser(userRegistration);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();

        (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe(PROFILE_URL));

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", PROFILE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Если со страницы профиля кликнуть по логотипу, то происходит переход на главную страницу")
    public void checkClickLogoButton() {
        UserRequests.createUser(userRegistration);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoButton();

        (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe(MAIN_URL));

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", MAIN_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Если со страницы профиля кликнуть по кнопке -Конструктор-, то происходит переход на главную страницу")
    public void checkClickConstructorButton() {
        UserRequests.createUser(userRegistration);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructorButton();

        (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe(MAIN_URL));

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", MAIN_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("При клике на кнопу -Выход- происходит выход из аккаунта и открывается страница авторизации")
    public void checkClickExitButton() {
        UserRequests.createUser(userRegistration);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.setLoginForm(userRegistration.getEmail(), userRegistration.getPassword());
        loginPage.clickLogInButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogOutButton();

        (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", LOGIN_PAGE_URL, driver.getCurrentUrl());

    }
}
