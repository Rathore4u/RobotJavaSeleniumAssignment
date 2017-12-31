################## Robot Test Automation Framework for Crossover ###############
This is an assignment done under Crossover Job opening for Test Automation Architect. It is a Test Automation Framework
ALong with few of the TestCases implemented for Crossover Job Portal
################################################################################



************ Technologies and Tools Used ***************************************
1. Core Java - programming language for writing page objects, locators and keyword implementation
2. Robot Files - For test cases to be written in Keyword oriented way under BDD design
3. TestNg - Used for API test cases if any, for UI it's purely Robot Keyword oriented
4. Maven - type of project to organize and execute
5. Dockerfile - used to execute on container image
6. Selenium webdriver and other test autmation related dependencies, mentioned in POM.
*********************************************************************************


************************ Framework components Brief *****************************

1. Pom - contains dependencies, profile if any and snapshot execution/ jar related xml tags
2. Acceptance - Folder containing integration/acceptance tests as per assignment given, these are mostly Robot files
following BDD using Keyword approach.
3. Src/Main/Java - contains Page Objects, Keyword Implementations, com.crossover.automation.pages.Locators and Utilities

Since here are only few cases, page objects and utilties classes, hence having them all in one package.
Ideally they would be kep separate from each other to maintain better structure.

**********************************************************************************


************************** Execution Steps ***************************************
Please use following steps to execute it on Docker

Docker plugin and it's configuration are inlcuded in pom.xml hence one can run it directly using docker instlled on his system. 

Please use following steps to execute it on local machine without docker

1. Remove docker plugin tags from Pom.xml or comment them for this
2. Execute using given run configuration which basically calls Tag names in order to execute particular cases only

3. Execute via console using following command.

"mvn clean install -Dinlcludetag=SearchJobs"

***********************************************************************************


************************* Improvements/Enhancements Suggested For this solution **********************************

Following could be added and extended to this basic framework
1. Reporting capabilities
2. Test Data input mechanisms including dataproviders of testng
3. PageObjectFactory to make sure at max one instance of any page object is alive throughout life cycle and so to save
memory and better execution time
4. Better structurization of utility and helper modules
5. Sample API test cases to showcase API test automation
6. Keyword profiling needed to perform
+many more minor suggestions

*******************************************************************************************************************

NOTE - Given test case should ideally fail for input "Chief" as there are only 23 job postings as of today which are
having chief in their title whereas default size of the result set is 25, hence it should fail. but i have printed as
many as titles having it (as a counter) and those which are not having given term in title are also printed via log.info

GithubRepo URL 
https://github.com/Rathore4u/RobotJavaSeleniumAssignment

Please get in touch at following email in case queries/suggestions.
mailTo: "mahiveatsastra@gmail.com"
