package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static api.constants.ApiAndUrl.*;

public class MainPage {
    private final WebDriver driver;
    private static final By ORDER_BUTTON = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button"); //Локатор кнопки "Оформить заказ"
    private static final By ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']"); //Локатор кнопки "Личный кабинет"
    private static final By BUNS_TAB = By.xpath(".//span[text()='Булки']"); //Локатор кнопки перехода в раздел "Булки"
    private static final By SAUCE_TAB = By.xpath(".//span[text()='Соусы']"); //Локатор кнопки перехода в раздел "Соусы"
    private static final By FILLINGS_TAB = By.xpath(".//span[text()='Начинки']"); //Локатор кнопки перехода в раздел "Начинки"
    private static final By CURRENT_MENU = By.cssSelector("div.tab_tab__1SPyG.tab_tab_type_current__2BEPc.pt-4.pr-10.pb-4.pl-10"); //Локатор текущего меню

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие главной страницы сайта")
    public void openPageMain() {
        driver.get(MAIN_URL);
        (new WebDriverWait(driver, Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe(MAIN_URL));
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
    }

    @Step("Проверка отображения кнопки Оформить заказ")
    public String getTextOrderButton() {
        (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_BUTTON));
        return driver.findElement(ORDER_BUTTON).getText();
    }

    @Step("Клик по кнопке Оформить заказ")
    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }

    @Step("Клик по кнопке Соусы")
    public void clickSauceTab() {
        (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(SAUCE_TAB));
        driver.findElement(SAUCE_TAB).click();
    }

    @Step("Клик по кнопке Начинки")
    public void clickFillingsTab() {
        driver.findElement(FILLINGS_TAB).click();
    }

    @Step("Клик по кнопке Булки")
    public void clickBunsTab() {
        (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.elementToBeClickable(BUNS_TAB));
        driver.findElement(BUNS_TAB).click();
    }

    @Step("Проверка текста текущего меню")
    public String getTextFromCurrentMenu() {
        return driver.findElement(CURRENT_MENU).getText();
    }
}
