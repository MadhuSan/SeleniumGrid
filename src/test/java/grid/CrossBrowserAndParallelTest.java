package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CrossBrowserAndParallelTest {
    public static WebDriver driver;
    @Test
    public void chromeTest() throws MalformedURLException, InterruptedException {
        String url = "https://www.gmail.com";
        String node = "http://10.50.95.121:8081/wd/hub";
        ChromeOptions opt = new ChromeOptions();
        opt.setCapability("Browser","chrome");
        driver = new RemoteWebDriver(new URL(node),opt);
        driver.navigate().to(url);
        System.out.println("Chrome output: " + driver.getTitle());
    }
    @Test
    public void fireFoxTest() throws MalformedURLException, InterruptedException {
        String url = "https://www.gmail.com";
        String node = "http://10.50.95.121:8082/wd/hub";
        FirefoxOptions fOpt = new FirefoxOptions();
        fOpt.setCapability("Browser","firefox");
        driver = new RemoteWebDriver(new URL(node),fOpt);
        driver.navigate().to(url);
        System.out.println("Firefox output: " + driver.getTitle());
        Thread.sleep(3000);
    }
    @Test
    public void ieTest() throws MalformedURLException, InterruptedException {
        String url = "https://www.gmail.com";
        String node = "http://10.50.95.121:8083/wd/hub";
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability("ignoreProtectedModeSettings", true);
        dc.setCapability("ie.ensureCleanSession", true);
        dc.setCapability("enableElementCacheCleanup", true);
        dc.setCapability("ignoreZoomSetting", true);
        driver = new RemoteWebDriver(new URL(node),dc);
        driver.navigate().to(url);
        System.out.println("ie output: " + driver.getTitle());
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
