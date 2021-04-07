package org.training.examples.automation.base;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.training.examples.automation.constants.GlobalConstants;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    GlobalConstants globalConstants;

    @BeforeClass
    @Parameters("browser")
    public void initSetup(String targetBrowser) throws Exception {
        globalConstants = new GlobalConstants();
        if (targetBrowser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", globalConstants.chromeDriverPath);
            driver = new ChromeDriver();
        }
      /* else if(targetBrowser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", globalConstants.edgeDriverPath);
            driver = new EdgeDriver();
        }
*/
        driver.manage().window().maximize();
        driver.get(globalConstants.appURL);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

        public WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}
