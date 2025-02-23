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
│   │       ├── pages/          # Page Object Model (POM) classes
│   │       ├── utils/          # Utility methods (reusable functions)
│   │       ├── base/           # Base classes for setup and teardown
│   ├── test/
│   │   └── java/
│   │       ├── tests/          # Test scripts
│   │       ├── config/         # Configuration files
├── pom.xml                     # Maven dependencies and configuration
├── README.md                   # Documentation
├── .gitignore                   # Git ignore file
└── .github/
        └── workflows/
                └── ci.yml      # GitHub Actions for CI/CD
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

## Installation
- Verify Appium Installation appium -v (install appium:  npm install -g appium) - brew install node - to run use appium
- Run Appium Doctor - to check missing dependencies - npm install -g appium-doctor - to run use appium-doctor
- start appium server - appium
- Install Appium Drivers (for Android & iOS)
    - appium driver install uiautomator2
    - appium driver install xcuitest
- Install Dependencies 
    - download Android Studio and Xcode
    - brew install carthage
- Verify Connected Devices
    - adb devices (for Android) or
    - idevice_id -l (for iOS)
echo 'export ANDROID_HOME=$HOME/Library/Android/sdk' >> ~/.zshrc
echo 'export PATH=$ANDROID_HOME/platform-tools:$PATH' >> ~/.zshrc
source ~/.zshrc
- Install libimobiledevice (for iOS)
    - brew install libimobiledevice
    - To check idevice_id -l
- After all checks pass (Initialize Maven)
    - mvn archetype:generate -DgroupId=com.example -DartifactId=SeleniumAppiumJava -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
- Update pom.xml with dependencies
    - then run (npm clean install)
- Also Install Chrome driver required
- To run test mvn test -Dplatform=web or mvn test -Dplatform=ios or mvn test -Dplatform=android


