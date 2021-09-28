package com.amazon.step_defs;

import com.amazon.pages.HomePage;
import com.amazon.pages.LaptopPage;
import com.amazon.pages.RelatedLinkPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import com.amazon.utilities.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.concurrent.Worker;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrawlDefs {
    LaptopPage laptopPage = new LaptopPage();
    RelatedLinkPage relatedLinkPage = new RelatedLinkPage();
    HomePage homePage = new HomePage();
    @Given("Click all drop down button")
    public void click_all_drop_down_button() {
        homePage.clickAllButton();
        BrowserUtils.waitForVisibility(homePage.seeAllStatement,10);
    }

    List<String> subDepartment = new ArrayList<>();
    List<String> urlS = new ArrayList<>();
    int rowNum=1;
    @When("Get a list of all department links and verify that no dead link exist")
    public void getAListOfAllDepartmentLinks() throws Exception {
        //prepare a worksheet
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");
        Row firstRow = sheet.createRow(0);
        //cell name
        Cell departmentCell = firstRow.createCell(0);
        departmentCell.setCellValue("Department");
        //cell name
        Cell subDeptCell = firstRow.createCell(1);
        subDeptCell.setCellValue("SubDepartment");
        //cell name
        Cell linkCell = firstRow.createCell(2);
        linkCell.setCellValue("Link");
        //cell name
        Cell statusCell = firstRow.createCell(3);
        statusCell.setCellValue("Status");

        homePage.seeAllStatement.click();
        List<WebElement> links;
        int a=5;
        WebElement department;
        //click all shopbyDepartment links orderly
        for(int i=0;i<22;i++){
            department = Driver.get().findElement(By.xpath("//a[@data-menu-id='"+a+"']"));
            String departmentName = department.getText();
            department.click();
            links = homePage.links;
            Thread.sleep(500);
            a++;
            //take all texts and urls of subdepartments
            for (i=0;i<links.size();i++){
                String subDepartmentName = links.get(i).getText();
                String url = links.get(i).getAttribute("href");
                urlS.add(url);
                Row nextRow = sheet.createRow(rowNum);
                rowNum++;
                //write each data based on the info
                Cell cell_1 = nextRow.createCell(0);
                cell_1.setCellValue(departmentName);
                Cell cell_2 = nextRow.createCell(1);
                cell_2.setCellValue(subDepartmentName);
                Cell cell_3 = nextRow.createCell(2);
                cell_3.setCellValue(url);

            }
            homePage.goBackMainMenu.click();
            Thread.sleep(500);
        }
        System.out.println("urlS.size() = " + urlS.size());
        //go and check that there is no dead link
        for (int i=0;i<urlS.size();i++) {
            Driver.get().navigate().to(urlS.get(i));
            BrowserUtils.waitForClickability(homePage.allDropDownButton.get(0),10);
            if(homePage.allDropDownButton.size()>0){
                ExcelUtils.setCellData(sheet,"OK","Status",i+1);
            }else {
                ExcelUtils.setCellData(sheet,"Dead link","Status",i+1);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_results.xls");
        workbook.write(fileOutputStream);
        //close text
        fileOutputStream.close();

    }

}
