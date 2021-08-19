package org.serg.framework.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.serg.framework.managers.DriverManager;

public class MyListnerAllure extends AllureJunit5 implements AfterTestExecutionCallback {


    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if(extensionContext.getExecutionException().isPresent()){
            Allure.getLifecycle().addAttachment("Scrin", "image/png", "png"
                    , ((TakesScreenshot) DriverManager.getDriverManager().getDriver())
                            .getScreenshotAs(OutputType.BYTES));
        }
    }
}
