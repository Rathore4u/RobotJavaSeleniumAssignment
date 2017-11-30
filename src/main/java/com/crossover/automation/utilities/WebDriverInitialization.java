package com.crossover.automation.utilities;

import com.crossover.automation.pages.Locators;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class WebDriverInitialization implements Locators {

    protected static WebDriver driver;

    public WebDriver getWebDriver() {
        if (driver == null) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(Locators.BASE_URL);
        }
        return driver;
    }
}