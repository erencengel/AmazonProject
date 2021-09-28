package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RelatedLinkPage {

    @FindBy(css = ".a-spacing-micro.s-navigation-indent-1>span")
    public WebElement linkName;

}
