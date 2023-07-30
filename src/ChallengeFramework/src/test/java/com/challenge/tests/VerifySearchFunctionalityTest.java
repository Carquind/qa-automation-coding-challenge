package com.challenge.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifySearchFunctionalityTest {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;
    private String searchTerm = "";
    private String invalidSearchTerm = "";
    
    @BeforeClass
    public void setUp() {
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Verify Search Functionality Test Report");
        sparkReporter.config().setReportName("Verify Search Functionality Test Report");
        extent.attachReporter(sparkReporter);

        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
    }

    @Test
    public void testSearchWithValidTerm() throws InterruptedException {
        test = extent.createTest("Test Search With Valid Term");
        searchTerm = "carquind";
        WebElement inputField = driver.findElement(By.tagName("input"));
        WebElement goButton = driver.findElement(By.tagName("button"));

        inputField.sendKeys(searchTerm);
        goButton.click();

        Thread.sleep(3000);

        // Wait until the search results are displayed
        WebElement searchResults = driver.findElement(By.cssSelector(".output-area"));

        // Assert that the search results are displayed correctly
        Assert.assertTrue(searchResults.isDisplayed(), "Search results not displayed");

        test.log(Status.PASS, "Search with valid term test passed");
    }

    @Test
    public void testSearchWithInvalidTerm() throws InterruptedException {
        test = extent.createTest("Test Search With Invalid Term");
        invalidSearchTerm = "!@#$%^";
        WebElement inputField = driver.findElement(By.tagName("input"));
        WebElement goButton = driver.findElement(By.tagName("button"));

        inputField.sendKeys(invalidSearchTerm);
        goButton.click();

        Thread.sleep(3000);

        // Wait until the generic error message is displayed when searching with an invalid term
        WebElement errorMessage = driver.findElement(By.cssSelector(".message-area"));
       
        // Assert that the generic error message is displayed when searching with an invalid term
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed");

        test.log(Status.PASS, "Search with invalid term test passed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
