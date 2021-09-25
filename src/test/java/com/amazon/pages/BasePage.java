package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "#twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(css = "#nav-search-submit-button")
    public WebElement searchClickButton;


}
