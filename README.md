# QA Automation Training with Java, Gardle, TestNG, Cucumber

## This repository contains the source code that is a result of the iterative process used to practice building from scratch, refining, and improving a Test Automation Framework based on Java, Gradle, TestNG and Cucumber.
---
### There are also video recording sessions that could be found [HERE](https://starsweb.sharepoint.com/sites/GRP_PAMKnowledgeBase/Shared%20Documents/Forms/AllItems.aspx?id=%2Fsites%2FGRP%5FPAMKnowledgeBase%2FShared%20Documents%2FQA%20Automation%20Training%20Sessions&viewid=e0f77818%2Daf72%2D4445%2D9cc4%2D47c02a4259e1).
If you don't have access to the folder with video recordings please contact Zsolt Hajdu - <zsolt_hajdu@flutterint.com>.

---
### Requirements:
1. [Java 11](https://adoptopenjdk.net/releases.html?variant=openjdk11)
1. [Gradle](https://gradle.org/install/)
1. [Git](https://git-scm.com/downloads)

Please follow the instructions provided by the above links in order to install the required software.

---
### To clone the repository:
- Create local directory where to clone the repository. Example using terminal:
```
C:\> mkdir working-dir
```
- Navigate to the created directory (using Explorer or terminal). Example using terminal:
```
cd working-dir
```
- Clone the repository. Example using terminal:

by using SSH ( [how to create and setup SSH](https://confluence.atlassian.com/bitbucketserver/creating-ssh-keys-776639788.html) ):
```
git clone ssh://git@git.pyrsoftware.ca:2222/~mirghcat/cluj-testing-team.git
```
by using HTTP ( you'll be asked for username and password ):
```
git clone https://git.pyrsoftware.ca/stash/scm/~mirghcat/cluj-testing-team.git
```

---
### Run tests using tags:
- For example to run all Test Scenarios that have tag ```@smoke```:

From terminal: 
  1. Open terminal/command prompt and navigate to the project folder (where is build.gradle file).
  1. In terminal/command prompt write and press enter: 
  ``` bash
  For Windows:
  gradlew.bat clean test -Dcucumber.filter.tags="@smoke"
  ```
  ``` bash
  For Unix:
  gradlew clean test -Dcucumber.filter.tags="@smoke"
  ```
---
  ### Run tests in parallel:
- The default thread count of the dataprovider in parallel mode is ```10```.
- To change this the ```dataproviderthreadcount``` property needs to be changed:

From terminal: 
  1. Open terminal/command prompt and navigate to the project folder (where is build.gradle file).
  1. To execute the tests with ```1 thread``` ( same as usual not parallel executions ), in terminal/command prompt write and press enter: 
  ``` bash
  For Windows:
  gradlew.bat clean test -Ddataproviderthreadcount=1
  ```
  ``` bash
  For Unix:
  gradlew clean test -Ddataproviderthreadcount=1
  ```
  3. To execute the tests with ```5 threads``` ( for example ), in terminal/command prompt write and press enter: 
  ``` bash
  For Windows:
  gradlew.bat clean test -Ddataproviderthreadcount=5
  ```
  ``` bash
  For Unix:
  gradlew clean test -Ddataproviderthreadcount=5
  ``` 
  4. You can combine executing tests in parallel and by using tags. FOr example to execute the tests with ```5 threads``` and the tests that you want to execute are with tag ```@smoke```, in terminal/command prompt write and press enter: 
  ``` bash
  For Windows:
  gradlew.bat clean test -Dcucumber.filter.tags="@smoke" -Ddataproviderthreadcount=5
  ```
  ``` bash
  For Unix:
  gradlew clean test -Dcucumber.filter.tags="@smoke" -Ddataproviderthreadcount=5
  ``` 
  5. ```IMPORTANT``` - If you skip using ```dataproviderthreadcount``` property, the test will be executed in parallel using the default thread count of the dataprovider in parallel mode which is ```10```.

---
### Run tests with specific browser:
- The browser management logic is implemented in ```BrowserManager.java``` ( following singleton pattern ). Full path to ```BrowserManager``` - ```java/pam/test/automation/managers/BrowserManager.java```.
- The default browser is ```Chrome``` so it will be used if you don't provide this parameter.
- To run tests with another browser`:

From terminal: 
  1. Open terminal/command prompt and navigate to the project folder (where is build.gradle file).
  1. To execute the tests with ```Firefox```, in terminal/command prompt write and press enter: 
  ``` bash
  For Windows:
  gradlew.bat clean test -Dbrowser=firefox
  ```
  ``` bash
  For Unix:
  gradlew clean test -Dbrowser=firefox
  ```
---
### Run tests with specific configuration:
- The files containing the parameters for different configuraions are provided in ```configs``` folder.
- The format of the files is ```env_name```.```properties```. They contain different ```key=value``` pairs that are used in the framework. For example different license urls, Admin tool url etc. Content example of qa.properties:
```
admin=https://tools1-uat.pyrsoftware.ca:5556/admin/index.shtml
com=https://ram.uat.pyr
bg=https://ram.uat-bg.pyr
ro=https://ram.uat-ro.pyr
```
- The configuration logic (reading the config files, loading the content, taking specific value) is implemented in ```ConfigManager.java``` ( following singleton pattern ). Full path to ```ConfigManager``` - ```java/pam/test/automation/managers/ConfigManager.java```.
- The default environment is ```qa```, so it will be used if you don't provide this parameter.
- To run tests with another environment:

From terminal: 
  1. Open terminal/command prompt and navigate to the project folder (where is build.gradle file).
  1. To execute the tests with ```uat``` environment configuration, in terminal/command prompt write and press enter: 
  ``` bash
  For Windows:
  gradlew.bat clean test -Denvironment=uat
  ```
  ``` bash
  For Unix:
  gradlew clean test -Denvironment=uat
  ```
---
Run tests with specific license url:
- The license url value is taken from the ```env_name```.```properties``` config file.
- The default license is ```com```, so it will be used if you don't provide this parameter.
- To run tests with another license:

From terminal: 
  1. Open terminal/command prompt and navigate to the project folder (where is build.gradle file).
  1. To execute the tests with ```ro``` license, in terminal/command prompt write and press enter: 
  ``` bash
  For Windows:
  gradlew.bat clean test -Dlicense=ro
  ```
  ``` bash
  For Unix:
  gradlew clean test -Dlicense=ro
  ```
---
### Example of using all parameters:
#### The following example will clean the build and execute the Cucumber tests with follwing specification:
- tag ```@smoke```
- in ```parallel``` using ```5 threads```
- in ```Edge``` browser
- for ```UAT``` environment
- for ```RO site (Romania)```
``` bash
  For Windows:
  gradlew.bat clean test  -Dcucumber.filter.tags="@smoke" -Ddataproviderthreadcount=5 -Dbrowser=edge -Denvironment=uat -Dlicense=ro
  ```
  ``` bash
  For Unix:
  gradlew clean test  -Dcucumber.filter.tags="@smoke" -Ddataproviderthreadcount=5 -Dbrowser=edge -Denvironment=uat -Dlicense=ro
  ```
---
### Generate Cucumber report:
After every test run a file with name ```cucumber-report.json``` is genarated. The full path to the file is ```build/cucumber/cucumber-report.json```. 

This is done by ```json``` plugin provided in the ```CucumberOptions``` in the ```CucumberTestRunner``` class:
``` bash
@CucumberOptions(
	plugin = {
			"json:build/cucumber/cucumber-report.json"
	},
	glue = "pam/test/automation/stepdefinitions",
	features = "src/test/resources/features",
	snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
	  @Override
	  @DataProvider(parallel = true)
	  public Object[][] scenarios() {
		  return super.scenarios();
	  }
}
```
If you need for some reason to change the path where the ```cucumber-report.json``` is generated, make sure that you apply this change also in ```generateReport()``` method in ```build.grale``` file. Skipping this will brake the report generation.

To generate the Cucumber report:

From terminal: 
  1. Open terminal/command prompt and navigate to the project folder (where is build.gradle file).
  1. In terminal/command prompt write and press enter: 
  ``` bash
  For Windows:
  gradlew.bat generateReport
  ```
  ``` bash
  For Unix:
  gradlew generateReport
  ```
  ```IMPORTANT``` - make sure that you don't execute ```clean``` task when you want generate report - this will delete ```build``` folder and ```build/cucumber/cucumber-report.json``` inclusive.