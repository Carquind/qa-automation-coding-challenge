package com.challenge.tests;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestRunner {
    public static void main(String[] args) {
        // Create ExtentReports and attach ExtentSparkReporter
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Test Execution Report");
        sparkReporter.config().setReportName("Automated Test Results");
        extent.attachReporter(sparkReporter);

        // Create TestNG instance and set the test classes
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[] {VerifySearchFunctionalityTest.class, VerifyUIElementsTest.class});

        // Set the listeners for TestNG to generate ExtentReports
        testNG.addListener(new ExtentReportListener(extent));

        // Run the TestNG suite
        testNG.run();
    }
}
