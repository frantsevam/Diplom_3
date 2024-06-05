import api.user.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.*;

import java.time.Duration;

import static api.constants.ApiAndUrl.*;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BeforeAndAfter {
    @Test
    @DisplayName("Успешная регистрация пользователя c валидным значением пароля")
    public void successRegistrationWithAllCorrectFields() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegisterPage();
        registrationPage.fillingInTheRegistrationFields(userRegistration);
        registrationPage.clickRegisterButton();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("При регистрации с невалидным значением для пароля появляется ошибка")
    public void registrationWithPasswordFiveSymbolsMistakeMessage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        userRegistration = UserGenerator.getIncorrectPasswordUser();

        registrationPage.openRegisterPage();
        registrationPage.fillingInTheRegistrationFields(userRegistration);

        String textError = registrationPage.getTextError();

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", "Некорректный пароль", textError);
    }

    @Test
    @DisplayName("При регистрации с невалидным значением для пароля, регистрация не проходит, пользователь остаётся на той же старнице")
    public void registrationWithPasswordFiveSymbols() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        userRegistration = UserGenerator.getIncorrectPasswordUser();

        registrationPage.openRegisterPage();
        registrationPage.fillingInTheRegistrationFields(userRegistration);
        registrationPage.clickRegisterButton();

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", REGISTER_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("При попытке зарегистрироваться с пустыми значениями полей, регистрация не происходит")
    public void registrationWithNoAnyData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        userRegistration.setName("");
        userRegistration.setPassword("");
        userRegistration.setEmail("");

        registrationPage.openRegisterPage();
        registrationPage.fillingInTheRegistrationFields(userRegistration);

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", REGISTER_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("При регистрации с пустым полем name - регистрация не проходит")
    public void registrationWithNoNameData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        userRegistration.setName("");

        registrationPage.openRegisterPage();
        registrationPage.fillingInTheRegistrationFields(userRegistration);

        assertEquals("Не соответствует ожидаемому резльтату!", REGISTER_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("При регистрации с пустым полем email - регистрация не проходит")
    public void registrationWithNoEmailData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        userRegistration.setEmail("");

        registrationPage.openRegisterPage();
        registrationPage.fillingInTheRegistrationFields(userRegistration);

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", REGISTER_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("При регистрации с пустым полем password - регистрация не проходит")
    public void registrationWithNoPasswordData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        userRegistration.setPassword("");

        registrationPage.openRegisterPage();
        registrationPage.fillingInTheRegistrationFields(userRegistration);

        Assert.assertEquals("Не соответствует ожидаемому резльтату!", REGISTER_PAGE_URL, driver.getCurrentUrl());
    }
}