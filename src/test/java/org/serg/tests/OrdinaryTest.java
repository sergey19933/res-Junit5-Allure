package org.serg.tests;


import org.junit.jupiter.api.Test;
import org.serg.tests.base.BaseTests;


public class OrdinaryTest extends BaseTests {

    @Test
    public void startTest() {
        app.getHomePage()
                .selectBaseMenu("Вклады")
                .selectSubMenu("Калькулятор доходности")
                .checkPage("Вклады")
                .choiceCurrency("Рубли")
                .fillFieldPage("Сумма вклада","300000")
                .fillFieldPage("Ежемесячное пополнение","50000")
                .investment("6 месяцев")
                .clickCheckboxPage("Ежемесячная капитализация","Включить")
                .clickCheckboxPage("Ежемесячная капитализация","Отключить")
                .clickCheckboxPage("Ежемесячная капитализация","Включить")
                .checkFillPage("К снятию через 6 месяцев:","562243,26")
                .checkFillPage("Начислено %:","12243,26")
                .checkFillPage("Пополнение за 6 месяцев:","250000");



    }


}
