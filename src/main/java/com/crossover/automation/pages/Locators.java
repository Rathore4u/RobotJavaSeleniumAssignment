package com.crossover.automation.pages;


public interface Locators {
    String BASE_URL = "http://www.google.com";
    String HOME_PAGE_URL = "https://www.crossover.com/";
    String HOME_PAGE_LANDING_URL = "https://www.crossover.com/#index";
    String HOME_PAGE_FOR_CANDIDATES = "a[href='/for-candidates/'] span";
    String HOME_PAGE_XO_LOGO_ID = "top";
    String JOBS_PAGE_SEE_AVAIALABLE_JOBS = "//div[@class='page-desc']/p/a[text()='SEE AVAILABLE JOBS']";
    String JOBS_PAGE_URL = "https://app.crossover.com/x/marketplace/available-jobs";
    String JOBS_PAGE_SEARCH_BUTTON = "//button[@type='submit']";
    String JOBS_PAGE_RESULT_LIST = "//a[@class='panel panel-default ng-scope']/div/div[1]";
    String JOBS_PAGE_RESET_BUTTON = "//button[text()='RESET']";
    String JOBS_PAGE_CATEGORY_DROPDOWN = "//span[text()='All Job Categories']";
    String JOBS_PAGE_SEARCH_INPUT = "//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty']";
    String JOBS_PAGE_XO_LOGO = "//div[@class='logo']";
    String HOME_PAGE_ALTERNATE_URL = "https://app.crossover.com/x/home";
}
