package org.serg.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.serg.framework.base.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='site-header__content-bottom']//span")
    private List<WebElement> choiceMainMenu;


    @FindBy(xpath = "//div[@class='nav__item-sub-nav']//nav[contains(@class,'nav__item-sub')]//a")
    private List<WebElement> choiceSubMenu;

    @Step("Выбор меню '{nameMainMenu}'")
    public HomePage selectBaseMenu(String nameMainMenu) {
        for (WebElement menuChoice : choiceMainMenu) {
            if (menuChoice.getText().trim().equalsIgnoreCase(nameMainMenu)) {
                waitUtilElementToBeClickable(menuChoice).click();
                return this;
            }
        }
        Assertions.fail("Меню '" + nameMainMenu + "' не найдено");
        return this;
    }


    @Step("Выбор под меню '{nameSubMenu}'")
    public DepositsPage selectSubMenu(String nameSubMenu) {
        for (WebElement menuChoice : choiceSubMenu) {
            if (menuChoice.getText().trim().equalsIgnoreCase(nameSubMenu)) {
                waitUtilElementToBeClickable(menuChoice).click();
                return pageManager.getDepositsPage();
            }
        }
        Assertions.fail("Меню '" + nameSubMenu + "' не найдено");
        return pageManager.getDepositsPage();
    }


}
