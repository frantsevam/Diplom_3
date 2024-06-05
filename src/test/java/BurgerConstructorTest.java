import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pom.MainPage;

public class BurgerConstructorTest extends BeforeAndAfter {
    @Test
    @DisplayName("При клике на раздел -Булки- открывается соответствующий раздел")
    public void clickBunsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPageMain();
        mainPage.clickSauceTab();
        mainPage.clickBunsTab();

        Assert.assertEquals("Ошибка при открытии раздела -Булки-", "Булки", mainPage.getTextFromCurrentMenu());
    }

    @Test
    @DisplayName("При клике на раздел -Соусы- открывается соответствующий раздел")
    public void clickSauceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPageMain();
        mainPage.clickSauceTab();

        Assert.assertEquals("Ошибка при открытии раздела -Соусы-", "Соусы", mainPage.getTextFromCurrentMenu());
    }

    @Test
    @DisplayName("При клике на раздел -Начинки- открывается соответствующий раздел")
    public void clickFillingsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPageMain();
        mainPage.clickFillingsTab();

        Assert.assertEquals("Ошибка при открытии раздела -Начинки-", "Начинки", mainPage.getTextFromCurrentMenu());
    }
}
