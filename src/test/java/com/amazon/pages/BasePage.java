package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "#twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(css = "#nav-search-submit-button")
    public WebElement searchClickButton;

    @FindBy(css = "#nav-hamburger-menu")
    public WebElement allDropDownButton;

    @FindBy(xpath = "(//div[.='see all'])[1]")
    public WebElement seeAllStatement;

    @FindBy(xpath = "//ul[@class='hmenu hmenu-visible hmenu-translateX']/li/a[@class='hmenu-item']")
    public List<WebElement> links;

    @FindBy(css = ".hmenu.hmenu-visible.hmenu-translateX>li>a>div")
    public WebElement goBackMainMenu;


}
