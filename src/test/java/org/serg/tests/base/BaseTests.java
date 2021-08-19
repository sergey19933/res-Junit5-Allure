package org.serg.tests.base;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.serg.framework.managers.DriverManager;
import org.serg.framework.managers.InitManager;

import static org.serg.framework.utils.PropConst.BASE_URL;

import org.serg.framework.managers.PageManager;
import org.serg.framework.managers.TestPropManager;
import org.serg.framework.utils.MyListnerAllure;

@ExtendWith(MyListnerAllure.class)
public class BaseTests {


    /**
     * Менеджер страничек
     *
     * @see PageManager#getPageManager()
     */
    protected PageManager app = PageManager.getPageManager();

    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    public void beforeEach() {
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
    }

    @AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
