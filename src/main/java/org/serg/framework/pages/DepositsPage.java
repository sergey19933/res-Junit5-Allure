package org.serg.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.serg.framework.base.BasePage;

import java.util.List;

public class DepositsPage extends BasePage {


    @FindBy(xpath = "//h1")
    private WebElement checkPage;

    @FindBy(xpath = "//div[@class='calculator__currency-row']//span[@class='calculator__currency-field-text']")
    private List<WebElement> choiceCurrency;

    @FindBy(xpath = "//select[@name='period']")
    private WebElement investment;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    private WebElement checkFillAccrued;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    private WebElement checkFillTopUp;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    private WebElement checkFillWithdrawing;


    @Step("Проверяем что открылась страница '{nameCheckPage}'")
    public DepositsPage checkPage(String nameCheckPage) {
        Assertions.assertEquals(nameCheckPage, checkPage.getText(), "Заголовок не соответствует требуемому");
        return this;
    }


    @Step("Выбираем валюту '{currency}'")
    public DepositsPage choiceCurrency(String currency) {
        for (WebElement menuChoice : choiceCurrency) {
            if (menuChoice.getText().trim().equalsIgnoreCase(currency)) {
                waitUtilElementToBeClickable(menuChoice).click();
                return this;
            }
        }
        Assertions.fail("Валюта '" + currency + "' не найдена");
        return this;
    }


    /**
     * Метод заполнения полей
     *
     * @param nameField - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     */
    @Step("Заполняем поле '{nameField}' значением '{value}'")
    public DepositsPage fillFieldPage(String nameField, String value) {
        pageManager.getMethodsUtilsPage().fillInputField(nameField, value);
        return this;
    }


    @Step("Выбор срока вложения '{value}'")
    public DepositsPage investment(String name) {
        scrollToElementJs(investment);
        Select selectInvestment = new Select(investment);
        selectInvestment.selectByVisibleText(name);
        return this;
    }

    @Step("Выбираем чекбокс '{nameField}' значением '{onOff}'")
    public DepositsPage clickCheckboxPage(String nameField, String onOff) {
        pageManager.getMethodsUtilsPage().choiceChekBox(nameField, onOff);
        actions.pause(1000).build().perform();
        return this;
    }

//    @Step("Проверка поле '{nameField}' значением '{value}'")
//    public DepositsPage clickCheckFillPage(String value) {
//        Assertions.assertEquals(checkFillWithdrawing.getText()
//                .replaceAll("[^0-9,]", ""), value, "Не совпадает");
//        return this;
//    }


    @Step("Проверяем поле '{nameField}' значением '{value}'")
    public DepositsPage checkFillPage(String nameField, String value) {

        switch (nameField) {
            case "К снятию через 6 месяцев:":
                Assertions.assertEquals(checkFillWithdrawing.getText()
                        .replaceAll("[^0-9,]", ""), value, "Не совпадает");
                break;
            case "Пополнение за 6 месяцев:":

                Assertions.assertEquals(checkFillTopUp.getText()
                        .replaceAll("[^0-9,]", ""), value, "Не совпадает");
                break;
            case "Начислено %:":

                Assertions.assertEquals(checkFillAccrued.getText()
                        .replaceAll("[^0-9,]", ""), value, "Не совпадает");
                break;
            default:
                Assertions.fail("Поле с наименованием '" + nameField + "' отсутствует на странице ");
        }

        return this;
    }


}
