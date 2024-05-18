# Functional E2E Automation

This project demonstrates functional automation for web UI testing using Selenium WebDriver or equivalent tools. The objective is to perform a search for 'Best Washing Machine' on Google, analyze the search results to count the number of Amazon and Flipkart links, and validate the titles and number of results on each Amazon and Flipkart link.

## Task Overview

- Open Google and perform a search for 'Best Washing Machine'.
- Get all search results displayed and validate how many Amazon and Flipkart links there are available (focusing only on the first page of the search results).
- Navigate to each Amazon and Flipkart link and confirm that the title is displayed and the number of results is greater than 0.

## Requirements

- If using Java, write a feature file in BDD style using the Gherkin language. If using any other language, any testing style can be used (e.g., FeatureSpec).
- Develop the automation framework for the above feature file / spec.

## Implementation

- **Feature File**: The BDD feature file (`search_washing_machine.feature`) defines the scenarios and steps in Gherkin language to describe the test case.
- **Automation Framework**: The automation framework utilizes Selenium WebDriver in Java to automate the steps described in the feature file. It includes necessary setup, actions, and validations.
- **Test Runner**: The test runner (`RunCucumberTest.java`) specifies the location of feature files and step definitions and orchestrates the execution of the tests using Cucumber.

## Getting Started

1. Clone this repository to your local machine.
2. Set up your development environment with Java and any necessary dependencies (such as Maven for Java projects).
3. Ensure you have the appropriate WebDriver executable (e.g., ChromeDriver) available and configured in your project.
4. Run the `RunCucumberTest.java` class as a JUnit test to execute the automation tests.

## Technologies Used

- Java
- Selenium WebDriver
- Cucumber
- JUnit

## Author
Palak Dua
