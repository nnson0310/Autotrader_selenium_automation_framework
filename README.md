### Skeleton framework for autotrader domain (Selenium Java + Junit 5)

## Table of Contents
1. [Important Note](https://github.com/nnson0310/Autotrader_selenium_automation_framework#important-note)
2. [Features](https://github.com/nnson0310/Autotrader_selenium_automation_framework#features)
3. [Project Structures](https://github.com/nnson0310/Autotrader_selenium_automation_framework#project-structures)
4. [Install](https://github.com/nnson0310/Autotrader_selenium_automation_framework#install)
5. [Listener Registration](https://github.com/nnson0310/Autotrader_selenium_automation_framework#listener-registration)
6. [Multiple environment running](https://github.com/nnson0310/Autotrader_selenium_automation_framework#multiple-environment-running)
7. [Record video](https://github.com/nnson0310/Autotrader_selenium_automation_framework#record-video)
8. [Allure Reports](https://github.com/nnson0310/Autotrader_selenium_automation_framework#allure-reports)
9. [Log4j2](https://github.com/nnson0310/Autotrader_selenium_automation_framework#log4j2)
10. [Data Management](https://github.com/nnson0310/Autotrader_selenium_automation_framework#data-management)
11. [Running testcases](https://github.com/nnson0310/Autotrader_selenium_automation_framework#running-testcases)
12. [Parallel testing](https://github.com/nnson0310/Autotrader_selenium_automation_framework#parallel-testing)

### Importan Note
````shell
+ Language binding is Java. Running stably with java version 11 (jdk 11.0.15)
+ This project uses latest selenium version 4.0.3
+ Public domain using for test: https://www.autotrader.com.au/ 
+ Using maven build tools to manage dependencies and third-party libraries
+ Generate reports with allure report
+ Using Junit 5 as automation framework
`````

**Important**: Because domain using for test is real domain (production) so test data can be invalid at the moment you run testcases. All using data are temporarily invalid at the moment I run testscripts. Update test data if you need.

### Features
+  Support demo running through local, docker selenium and cloud testing with proper configuration
+  Generate report and log file.
+  Support cross-browser testing: chrome, firefox, headless browser, opera, edge, safari....
+  Generate allure report with attached screenshot at failed step (only failed step)
+  Auto record video when running testcases on local environment
+  Auto save record video from BrowserStack through API call
+  Can be intergrated with CI-CD tools like Jenkins.
+  Register listeners through Service Provider mechanism...and so on.

### Project Structures
This project has some main important components:
+ src folder: contains two packages (main + test). `Main packages` will contains many smaller packages which are mainly used for: Selenium API methods wrapping, init BrowserDriver, interfaces, custom exception, API call, enums, constants definition...In constrast, `Test packages` contains testcases.
+ resources folder: contains resources using for listener registration, properties files, test data files...
+ other folders as: browser driver, log4j, allure report...

### Install
Clone project to your local device and run below maven command:
```sh
mvn install
mvn clean test 
```
### Listener Registration
Junit 5 support listener registration through [`ServiceLoader`](https://junit.org/junit5/docs/current/user-guide/#launcher-api-listeners-custom) mechanism of Java. Create your own listeners and declare it with `src/main/resources/META-INF/services`. Two default listeners are registered in `src/main/java/listeners`

### Multiple environment running:
Support running on local device, docker grid and cloud testing platform (BrowserStack). Config `src/main/resources/environment.properties` file to adapt to your requirements:
+ environment_name: valid value is `local, grid, docker`
+ browser_name, browser_version, os, os_version: config for `BrowserStack`
+ ip_address, port: config for docker grid (default port for selenium hub is `4444`)

Run on environment except local:
- To run docker grid, you only need to run `docker-compose-up.bat` file to auto pull and create docker container. To remove all docker containers, run `docker-compose-down.bat` file.
- To run BrowserStack, config your credentials in `src/main/resources/project.properties` file

### Record video:
+ **Local**: auto create new video in `record-videos` folder. Note: to save resources, auto delete all old videos in this folder.
+ **Docker Grid**: [docker-selenium](https://github.com/SeleniumHQ/docker-selenium) introduces new record features. When running, you can directly watch video by accessing browser session (`password: secret`).
  **Note: You have to remove all containers to stop running if you want to get record videos. Video will be saved in `dockervideos` folder. See `docker-compose.yml` for details**
+ **BrowserStack**: you have two options: only download latest video or download all videos of latest build. See `src/main/java/listeners/StateExecutionListener.java` for details

### Allure Reports:
To generate allure reports in `allure-report` folder, you need to run below command:
```shell
mvn clean test allure:report
or
mvn clean test allure:serve
```
Config environment parameters for allure reports with `src/main/resources/project.properties`.
Screenshot will be attached to report when testcase is marked as failure (only at failed test step). Screenshot will be automatically saved as png image.
### Log4j2
Config `src/test/resources/log4j2.xml` due to your requirements. Auto create `app.log` file in `log4j2` folder.

### Data Management
Test data can be managed through many ways. Junit 5 supports data-driven testing with `@ParameterizedTest` annotation. All temporary testdata (at my running time) are stored in `src/test/resources/test_data/`. You can freely choose between csv or json file. 
+ If you choose json files, test data must be mapped to Java Object using [Gson Library](https://mvnrepository.com/artifact/com.google.code.gson/gson)
+ If you choose csv files, simply adding `@CsvFileSource(resources = "/path_to_csv_file", numLinesToSkip = 1)` below `@ParamerterizedTest` annotation

### Running testcases:
Config `pom.xml`. Change `groups` tag corresponding to value of `@Tag` annotation

### Parallel testing:
This is experimental features of Junit 5. This framework can not be conducted by parallel. Uncomment lines in `pom.xml` and add `@Execution(ExecutionMode.CONCURRENT)` to `BaseTest` class. All test class extends from `BaseTest` will be runned in parallel. Read [Junit 5 Parallel](https://junit.org/junit5/docs/snapshot/user-guide/#writing-tests-parallel-execution) tests for more details.
