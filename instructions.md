# How to Run the Tests

## **IDE Execution**
### 1)	**Prerequisites**
- Ensure you have Java Development Kit (JDK) installed on your computer.
- Install an Integrated Development Environment (IDE) like Eclipse or IntelliJ IDEA.
- Make sure you have Google Chrome browser installed.
- Set up the project with the necessary dependencies, including TestNG and WebDriver.
- Install Maven on your system.

### 2)	**Clone the Project**
- Clone the project repository from GitHub to your local machine.

### 3)	**Open the Project in IDE**
- Open the IDE and import the project into it.

### 4)	**Set Up WebDriver**
- If your ChromeDriver version doesn't match the installed Chrome browser version, you may need to update the ChromeDriver binary in the project. 
- Download the appropriate ChromeDriver executable from the official website (https://sites.google.com/chromium.org/driver/).
- Place the downloaded ChromeDriver executable in a directory within the project.

### 5)	**Verify TestNG Dependency**
- Ensure that TestNG is correctly configured as a dependency in the project's build path.

### 6)	**Run Test Scripts**
- Locate the TestRunner class in the project.
- Right-click on the TestRunner class.
- Select "Run As" or "Run" from the context menu.
- Choose "TestNG Test" or "Java Application" to execute the tests.

### 7)	**Monitor Test Execution**
- The tests will start executing, and you will see the test progress in the IDE's console.
- Each test method's status (Passed, Failed, Skipped) will be displayed in the console output.

### 8)	**View Test Reports**
- After the test execution completes, an Extent HTML report will be generated in the "test-output" folder.
- Open the generated ExtentReport.html file in a web browser to view detailed test results and captured information during test execution.

### 9)	**Troubleshooting**
- If any test fails, review the test report for more detailed information about the failures.
- Check the logs and error messages generated during test execution for any issues.


## **Command Line Execution**

### 1)	**Prerequisites**
- Ensure you have Java Development Kit (JDK) installed on your computer.
- Set up the project with the necessary dependencies, including TestNG and WebDriver.
- Verify that the ChromeDriver executable is available in the project.

### 2)	**Open Command Prompt (Windows) or Terminal (macOS/Linux)**
- Open the command-line interface on your computer.

### 3)	**Navigate to Project Directory**
- Use the `cd` command to navigate to the root directory of your project where the `pom.xml` file is located.

### 4)	**Build the Project**
- Run the following command to build the project and download any necessary dependencies:
```
mvn clean install
```
This command will compile the project and download required libraries.

### 5)	**Run the Tests**
- After the build is successful, run the following command to execute the tests:
```
mvn clean test
```
This command will trigger TestNG to execute the test suite defined in the TestRunner class.

### 6)	**Monitor Test Execution**
- The tests will start executing, and you will see the test progress in the command-line interface.
- Each test method's status (Passed, Failed, Skipped) will be displayed in the console output.

### 7)	**View Test Reports**
- After the test execution completes, an Extent HTML report will be generated in the "test-output" folder.
- Open the generated ExtentReport.html file in a web browser to view detailed test results and captured information during test execution.

### 8)	**Troubleshooting**
- If any test fails, review the test report for more detailed information about the failures.
- Check the logs and error messages generated during test execution for any issues.
