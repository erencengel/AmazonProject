package com.amazon.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    //waits for the provided element to be clickable
    public static WebElement waitForClickability(WebElement element, int timeout){
        WebDriverWait webDriverWait = new WebDriverWait(Driver.get(),timeout);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //waits for the provided element to be visibility
    public static WebElement waitForVisibility(WebElement element, int timeout){
        WebDriverWait webDriverWait = new WebDriverWait(Driver.get(),timeout);
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
