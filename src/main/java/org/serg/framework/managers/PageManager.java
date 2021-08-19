package org.serg.framework.managers;

import org.serg.framework.pages.*;
import org.serg.framework.utils.MethodsUtils;


public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private HomePage homePage;

    /**
     * Страничка со вкладами
     */
    private DepositsPage depositsPage;


    /**
     * Страничка с утилитарными методами
     */
    private MethodsUtils methodsUtils;



    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link HomePage}
     *
     * @return homePage
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link DepositsPage}
     *
     * @return laptopPage
     */
    public DepositsPage getDepositsPage() {
        if (depositsPage == null) {
            depositsPage = new DepositsPage();
        }
        return depositsPage;
    }

    /**
     * Ленивая инициализация {@link MethodsUtils}
     *
     * @return methodsUtils
     */
    public MethodsUtils getMethodsUtilsPage() {
        if (methodsUtils == null) {
            methodsUtils = new MethodsUtils();
        }
        return methodsUtils;
    }



}


