package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Set;

public class ShoppingCartPage extends BasePage{

    @FindBy(css = ".a-truncate-cut")
    public List<WebElement> eachProduct;

    @FindBy(css = "#productTitle")
    public WebElement productTitle;

}
