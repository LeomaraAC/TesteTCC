package until;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    public static WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), 30);
    }
}
