package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IETest {
    public static WebDriver driver;
/*    @Test
    public void ieTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability("ignoreProtectedModeSettings", true);
        dc.setCapability("ie.ensureCleanSession", true);
        dc.setCapability("enableElementCacheCleanup", true);
        dc.setCapability("ignoreZoomSetting", true);
        URL url = new URL("http://10.50.89.180:8082/wd/hub");
        driver = new RemoteWebDriver(url,dc);
        driver.get("https://www.google.com/");
        System.out.println("output: " + driver.getTitle());
        driver.quit();
    }*/
}

