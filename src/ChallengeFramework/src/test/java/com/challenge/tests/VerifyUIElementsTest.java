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

public class VerifyUIElementsTest {
    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setUp() {
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Verify UI Elements Test Report");
        sparkReporter.config().setReportName("Verify UI Elements Test Report");
        extent.attachReporter(sparkReporter);

        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
    }

    @Test
    public void testHeaderDisplaysCorrectTitle() throws InterruptedException {
        test = extent.createTest("Test Header Displays Correct Title");
        WebElement header = driver.findElement(By.tagName("h1"));
        String expectedTitle = "Get Github Repos";
        
        Thread.sleep(3000);
        
        Assert.assertEquals(header.getText(), expectedTitle, "Header title mismatch");

        test.log(Status.PASS, "Header displays correct title test passed");
    }

    @Test
    public void testSearchFormPresence() throws InterruptedException {
        test = extent.createTest("Test Search Form Presence");
        WebElement searchForm = driver.findElement(By.tagName("form"));
        WebElement inputField = searchForm.findElement(By.tagName("input"));
        WebElement goButton = searchForm.findElement(By.tagName("button"));

        Thread.sleep(3000);
        
        // Assert that the search form, input field, and go button are displayed
        Assert.assertTrue(searchForm.isDisplayed(), "Search form not displayed");
        Assert.assertTrue(inputField.isDisplayed(), "Input field not displayed");
        Assert.assertTrue(goButton.isDisplayed(), "Go button not displayed");

        test.log(Status.PASS, "Search form presence test passed");
    }

    @Test
    public void testSearchResultSectionPresence() throws InterruptedException {
        test = extent.createTest("Test Search Result Section Presence");
        Thread.sleep(3000);
        WebElement searchResultSection = driver.findElement(By.cssSelector(".output-area"));
        String displayProperty = searchResultSection.getCssValue("display");
        
        // Assert that the search result section is displayed and initially empty
        Assert.assertTrue(searchResultSection.isDisplayed(), "Search result section not displayed");
        Assert.assertEquals(displayProperty, "flex", "Search result section is not empty");

        test.log(Status.PASS, "Search result section presence test passed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
