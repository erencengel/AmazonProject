package com.amazon.step_defs;

import com.amazon.pages.HomePage;
import com.amazon.pages.LaptopPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.*;

public class StockDefs {

    //jsExecutor
    JavascriptExecutor jse = (JavascriptExecutor) Driver.get();

    //create a global HomePage object
    HomePage homePage = new HomePage();


    @Given("Go to homepage")
    public void go_to_homepage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @Then("Verify that title contains {string}")
    public void verifyThatTitleContains(String expectedTitle) {
        System.out.println("expectedTitle = " + expectedTitle);
        //get the actual title
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        //verify that expected and actual are same
        Assert.assertEquals(expectedTitle,actualTitle);
    }


    @Given("Send {string} into the search box")
    public void sendIntoTheSearchBox(String productName) {
        //send product name into the search box
        homePage.searchBox.sendKeys(productName);
    }

    @When("Click search box")
    public void clickSearchBox() {
        homePage.click();
    }

    //create a global object based on the LaptopPage class
    LaptopPage laptopPage = new LaptopPage();
    @Then("Select non-discounted products and add into the stock")
    public void selectNonDiscountedProductsAndAddIntoTheStock() {

        List<WebElement> laptopIcon = laptopPage.laptopIcon;
        //number of laptopIcon;
        int laptopNumber = laptopIcon.size();

        for (int i=0;i<5;i++){
            laptopIcon.get(i).click();
            BrowserUtils.waitForClickability(new LaptopPage().addToCardButton,10);

            try {
                if(new LaptopPage().listPriceForDiscount.getText().contains("List")){}
            }catch (RuntimeException runtimeException){
                new LaptopPage().addToCardButton.click();
                BrowserUtils.waitForClickability(new LaptopPage().cartSign,10);
                Driver.get().navigate().back();
                BrowserUtils.waitForClickability(new LaptopPage().addToCardButton,10);
            }

            Driver.get().navigate().back();
            BrowserUtils.waitForVisibility(new LaptopPage().laptopStatement,10);
        }

    }
}
