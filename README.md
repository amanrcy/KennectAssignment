# Test Automation Script - Assignment Task 1

## Overview
This test script automates the process of logging into a web application, adding a patient, selecting tests, and adding equipment to the patient's record. The script is implemented using Selenium WebDriver with TestNG and is designed to ensure smooth interaction with various elements in the application.

## Features
- Login: Automates the login using valid credentials.
- Navigate to Tests: Navigates through the application to add a patient.
- Add Patient Details: Enters patient information such as name, email, age, height, weight, etc.
- Add Tests and Equipment: Selects and adds tests, discounts, lab recommendations, doctor commission, and adds equipment.

## Test Status
- The test has passed successfully for most steps.
- Issue Identified: There is an error when attempting to add equipment to the patient's record. The issue needs to be investigated by the development team.
  
## Observations
- Element Locators:
  - XPath and CSS Selectors are powerful for locating elements but might need some optimization.
  - Using unique IDs for elements can improve test reliability and make it easier for smoother testing in some cases.

## Areas for Developer Attention
- Investigate and fix the issue with adding equipment.
- Consider using unique IDs for elements to improve the robustness and maintainability of the test scripts.

## Requirements
- Java 11 or higher
- Selenium WebDriver
- TestNG
- WebDriverManager
- Browser: Edge (configured with WebDriverManager)

## How to Run
1. Clone the repository to your local machine.
2. Set up your environment with the necessary dependencies (Selenium, TestNG, etc.).
3. Run the test script using any IDE like IntelliJ or Eclipse.
4. Ensure the necessary drivers are available for the browser you are using.

## Conclusion
This script helps in automating the testing process and can be enhanced by addressing the identified issue with adding equipment and exploring the use of unique element IDs for more stable test execution.
