package com.amazon.step_defs;

import com.amazon.pages.HomePage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CrawlDefs {

    HomePage homePage = new HomePage();
    @Given("Click all drop down button")
    public void click_all_drop_down_button() {
        homePage.clickAllButton();
        BrowserUtils.waitForVisibility(homePage.seeAllStatement,10);
    }


    List<String> urlS = new ArrayList<>();
    List<String> nameofLinks = new ArrayList<>();
    @When("Get a list of all department links")
    public void getAListOfAllDepartmentLinks() throws InterruptedException {
        homePage.seeAllStatement.click();
        List<WebElement> links = homePage.links;
        int a=5;
        for(int i=0;i<22;i++){
            Driver.get().findElement(By.xpath("//a[@data-menu-id='"+a+"']")).click();
            Thread.sleep(500);
            a++;

            for (i=0;i<links.size();i++){
                urlS.add(links.get(i).getAttribute("href"));
                nameofLinks.add(links.get(i).getText());
            }
            homePage.goBackMainMenu.click();
            Thread.sleep(500);
        }
        System.out.println("urlS.size() = " + urlS.size());
        for (String url : urlS) {
            System.out.println(url);
        }
        System.out.println("");
        System.out.println("nameofLinks.size() = " + nameofLinks.size());
        for (String nameofLink : nameofLinks) {
            System.out.println(nameofLink);
        }

    }
}
