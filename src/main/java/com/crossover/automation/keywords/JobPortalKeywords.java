package com.crossover.automation.keywords;

import com.crossover.automation.pages.JobsPage;
import com.crossover.automation.pages.XoHomePage;
import com.crossover.automation.utilities.WebDriverInitialization;
import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import java.util.logging.Logger;


@RobotKeywords
public class JobPortalKeywords extends WebDriverInitialization {

    Logger log = Logger.getLogger(JobPortalKeywords.class.getName());
    public static final String URL_HOME_PAGE = "https://www.crossover.com/";
    XoHomePage homepage;
    JobsPage jobsPage;

    @RobotKeyword
    public WebDriver openLocalBrowser(){
        return getWebDriver();
    }

    @RobotKeyword
    public void closeLocalBrowser(){
        if(driver!=null){
            driver.close();
            driver.quit();
        }else{
            log.info("Driver Instance is already null");
        }
    }

    @RobotKeyword
    public void openHomePage() {
        homepage = PageFactory.initElements(WebDriverInitialization.driver, XoHomePage.class);
        homepage.openUrl(URL_HOME_PAGE);
    }

    @RobotKeyword
    public void verifyHomePageOpen(){
        homepage = PageFactory.initElements(WebDriverInitialization.driver, XoHomePage.class);
        homepage.verifyHomePageOpen();
    }

    @RobotKeyword
    public void clickMenuOnHomePage(String menuName){
        homepage = PageFactory.initElements(WebDriverInitialization.driver, XoHomePage.class);
        switch(menuName){
            case "FOR CANDIDATES":
                homepage.openCandidatesMenu();
                break;
            default:
                log.info("Given menu option is not available to click or invalid menu item ");
                break;

        }
    }

    @RobotKeyword
    public void verifyCandidatesPageOpen(){
        homepage = PageFactory.initElements(WebDriverInitialization.driver, XoHomePage.class);
        homepage.verifyCandidatesPageOpened();
    }

    @RobotKeyword
    public void clickHyperlinkOnCandidatesPage(String hyperlinkText){
        homepage = PageFactory.initElements(WebDriverInitialization.driver, XoHomePage.class);
        homepage.openCandidatesPage(hyperlinkText);
    }

    @RobotKeyword
    public void verifyJobsSegmentOpen(){
        homepage = PageFactory.initElements(WebDriverInitialization.driver, XoHomePage.class);
        homepage.verifyJobsSegmentOpened();
    }

    @RobotKeyword
    public void focusOnSearchField(){
        jobsPage = PageFactory.initElements(WebDriverInitialization.driver, JobsPage.class);
        jobsPage.focusOnSearchField();
    }

    @RobotKeyword
    public void verifyFieldFocused(){
        jobsPage = PageFactory.initElements(WebDriverInitialization.driver, JobsPage.class);
        jobsPage.verifyFocusOnSearchInputText();
    }

    @RobotKeyword
    public void searchKeywordForAvailableJobs(String searchTerm){
        jobsPage = PageFactory.initElements(WebDriverInitialization.driver, JobsPage.class);
        jobsPage.searchText(searchTerm);
        jobsPage.verifyResults(searchTerm);
    }

    @RobotKeyword
    public void resetResults(){
        jobsPage = PageFactory.initElements(WebDriverInitialization.driver, JobsPage.class);
        jobsPage.resetResults();
    }

    @RobotKeyword
    public void selectJobCategoryFromCategoryFilter(String categoryName){
        jobsPage = PageFactory.initElements(WebDriverInitialization.driver, JobsPage.class);
        jobsPage.selectJobCategory(categoryName);
    }

    @RobotKeyword
    public void navigateToHomePageUsingLogo(){
        jobsPage = PageFactory.initElements(WebDriverInitialization.driver, JobsPage.class);
        jobsPage.openHomePageFromJobsPage();
    }

}
