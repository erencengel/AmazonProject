package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaptopPage extends BasePage{

    @FindBy(css = ".a-size-medium.a-color-base.a-text-normal")
    public List<WebElement> laptopIcon;

    @FindBy(css = "#add-to-cart-button")
    public WebElement addToCardButton;

    @FindBy(xpath = "//td[.='List Price:']")
    public List<WebElement> listPriceForDiscount;

    @FindBy(css = "#nav-cart-count-container")
    public WebElement cartSign;

    @FindBy(xpath = "//span[.='\"laptop\"']")
    public WebElement laptopStatement; //for dynamic wait

    @FindBy(css = "#productTitle")
    public WebElement textOfEachLaptop;

    @FindBy(css = "#attach-close_sideSheet-link")
    public List<WebElement> popUp;

}
