package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaptopPage extends BasePage{

    @FindBy(css = "img[class='s-image']")
    public List<WebElement> laptopIcon;

    @FindBy(css = "#add-to-cart-button")
    public WebElement addToCardButton;

    @FindBy(xpath = "//td[.='List Price:']")
    public WebElement listPriceForDiscount;

    @FindBy(css = "#nav-cart-count-container")
    public WebElement cartSign;

    @FindBy(xpath = "//span[.='\"laptop\"']")
    public WebElement laptopStatement; //for dynamic wait

}
