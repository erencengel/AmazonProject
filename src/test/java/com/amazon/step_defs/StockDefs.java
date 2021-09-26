package com.amazon.step_defs;

import com.amazon.pages.HomePage;
import com.amazon.pages.LaptopPage;
import com.amazon.pages.ShoppingCartPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.*;

public class StockDefs {

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
    Set<String> expectedList0fLaptop = new TreeSet<>();
    @Then("Select non-discounted products and add into the stock")
    public void selectNonDiscountedProductsAndAddIntoTheStock() {

        List<WebElement> laptopIcon = laptopPage.laptopIcon;
        //number of laptopIcon;
        int laptopNumber = laptopIcon.size();

        for (int i=0;i<5;i++){
            laptopIcon.get(i).click();
            BrowserUtils.waitForClickability(laptopPage.addToCardButton,10);
            if(laptopPage.listPriceForDiscount.size()==0){
                //create expected list of laptop
                expectedList0fLaptop.add(laptopPage.textOfEachLaptop.getText());
                laptopPage.addToCardButton.click();
                BrowserUtils.waitForClickability(laptopPage.cartSign,10);
                Driver.get().get("https://www.amazon.com/s?k=laptop&ref=nb_sb_noss_2");
            }else {
                Driver.get().navigate().back();
            }
            BrowserUtils.waitForVisibility(laptopPage.laptopStatement,10);
        }
        System.out.println("expectedList0fLaptop = " + expectedList0fLaptop);
        System.out.println("expectedList0fLaptop.size() = " + expectedList0fLaptop.size());
    }


    @Given("Go to inputbox")
    public void goToInputbox() {
        laptopPage.cartSign.click();
        BrowserUtils.waitForClickability(laptopPage.cartSign,10);
    }


    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    Set<String> actualListOfLaptop = new TreeSet<>();
    @When("Take all products and place in a set")
    public void takeAllProductsandPlaceinaSet() {

        for(int i=0;i<shoppingCartPage.eachProduct.size();i++){
            WebElement element = shoppingCartPage.eachProduct.get(i);
            String text = element.getText();
            String finalText = text.substring(0,text.length()-1);
            actualListOfLaptop.add(finalText);
        }

        System.out.println("actualListOfLaptop = " + actualListOfLaptop);
        System.out.println("actualListOfLaptop.size() = " + actualListOfLaptop.size());

    }


    List<String> expected = new ArrayList<>();
    List<String> actual = new ArrayList<>();
    @Then("Verify the products are right")
    public void verifyTheProductsAreRight() {
        for (String str : expectedList0fLaptop) {
            expected.add(str);
        }
        System.out.println("expected = " + expected);
        for (String s : actualListOfLaptop) {
            actual.add(s);
        }
        System.out.println("actual = " + actual);
        //verify lists are the same
        for (int i=0;i<expected.size();i++){
            Assert.assertTrue(expected.get(i).contains(actual.get(i)));
        }
    }
}
