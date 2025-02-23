# SeleniumAppiumJava Test Framework

This repository contains a test framework for web and mobile (iOS and Android) applications using Selenium, Maven, Appium, and Java. The framework is designed to be reusable and maintainable, with a structured folder layout and integration with GitHub Actions for continuous integration.

## Table of Contents
- [Installation](#installation)
    - [Java](#java)
    - [Maven](#maven)
    - [Appium](#appium)
- [Folder Structure](#folder-structure)
- [Sample Test](#sample-test)
- [Running Tests with GitHub Actions](#running-tests-with-github-actions)

## Installation

### Java
1. Download and install the latest JDK from the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Set the `JAVA_HOME` environment variable to the JDK installation path.
3. Add the `JAVA_HOME/bin` directory to your `PATH` environment variable.

### Maven
1. Download and install Maven from the [Apache Maven website](https://maven.apache.org/download.cgi).
2. Set the `MAVEN_HOME` environment variable to the Maven installation path.
3. Add the `MAVEN_HOME/bin` directory to your `PATH` environment variable.

### Appium
1. Install Node.js from the [Node.js website](https://nodejs.org/).
2. Install Appium globally using npm:
     ```sh
     npm install -g appium
     ```
3. Verify the installation by running:
     ```sh
     appium -v
     ```

## Folder Structure
```
SeleniumAppiumJava/
├── src/
│   ├── main/
│   │   └── java/
│   └── test/
│       └── java/
│           ├── tests/
│           ├── utils/
│           └── config/
├── pom.xml
├── README.md
└── .github/
        └── workflows/
                └── ci.yml
```

- `src/main/java/`: Contains the main Java code (if any).
- `src/test/java/`: Contains the test code.
    - `tests/`: Contains the test classes.
    - `utils/`: Contains utility classes and methods.
    - `config/`: Contains configuration files and classes.
- `pom.xml`: Maven configuration file.
- `.github/workflows/ci.yml`: GitHub Actions workflow file for continuous integration.

## Sample Test
Create a sample test in `src/test/java/tests/SampleTest.java`:
```java
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest {
        private WebDriver driver;

        @BeforeClass
        public void setUp() {
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                driver = new ChromeDriver();
        }

        @Test
        public void testGoogleSearch() {
                driver.get("https://www.google.com");
                // Add assertions and test steps here
        }

        @AfterClass
        public void tearDown() {
                if (driver != null) {
                        driver.quit();
                }
        }
}
```

## Running Tests with GitHub Actions
GitHub Actions workflow file in `.github/workflows/ci.yml`:

This workflow will run the tests on every push and pull request.
