package org.serg.framework.utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.serg.framework.base.BasePage;
import org.serg.framework.managers.DriverManager;

public class MethodsUtils extends BasePage {


    /**
     * @param nameField название поля
     * @param value     заполняемое значение
     */
    public void fillInputField(String nameField, String value) {
        String xPath = "//label[@class='calculator__slide-input-label' and contains(text(),'" + nameField + "')]//..//input[@type='text']";
        WebElement webElement = DriverManager.getDriverManager().getDriver().findElement(By.xpath(xPath));
        scrollToElementJs(webElement);
        waitUtilElementToBeVisible(webElement);
        waitUtilElementToBeClickable(webElement);
        webElement.sendKeys(value);

        Assertions.assertEquals(webElement.getAttribute("value")
                .replaceAll("\\D*", ""), value, "Поле введено не верно");
    }

    /**
     * @param nameBox название чекбокса
     * @param onOff   Включение/Отключение чекбокса
     */
    public void choiceChekBox(String nameBox, String onOff) {
        if (onOff.equalsIgnoreCase("Включить")) {
            try {
                String xPath = "//span[contains (text(),'" + nameBox + "')]/../..//div[@class='jq-checkbox calculator__check']";
                WebElement webElement = DriverManager.getDriverManager().getDriver().findElement(By.xpath(xPath));
                waitUtilElementToBeVisible(webElement);
                waitUtilElementToBeClickable(webElement);
                webElement.click();
            } catch (NoSuchElementException e) {
            }
        } else if (onOff.equalsIgnoreCase("Отключить")) {
            try {
                String xPath = "//span[contains (text(),'" + nameBox + "')]//..//..//div[@class='jq-checkbox calculator__check checked']";
                WebElement webElement = DriverManager.getDriverManager().getDriver().findElement(By.xpath(xPath));
                waitUtilElementToBeVisible(webElement);
                waitUtilElementToBeClickable(webElement);
                webElement.click();
            } catch (NoSuchElementException e) {
            }
        }
    }


}
