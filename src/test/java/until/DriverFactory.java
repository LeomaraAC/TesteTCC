package until;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> threadDrive = new InheritableThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue(){
            return initDrive();
        }
    };

    private DriverFactory() {}

    public static WebDriver getDriver() {
        return threadDrive.get();
    }

    public static WebDriver initDrive() {
        WebDriver driver = null;
        switch (Propriedades.browser) {
            case Chrome:
                driver = new ChromeDriver();
                break;
            case Firefox:
                driver = new FirefoxDriver();
                break;
            case Edge:
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void killDriver(){
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (threadDrive != null) {
            threadDrive.remove();
        }
    }
}
