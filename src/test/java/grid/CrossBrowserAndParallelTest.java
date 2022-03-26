package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
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
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--headless");
        opt.addArguments("--disable-dev-shm-usage");
        URL url = new URL("http://10.50.95.121:8080/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, opt);
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void fireFoxTest() throws MalformedURLException, InterruptedException {
        String url = "https://www.gmail.com";
        String node = "http://10.50.95.121:8081/wd/hub";
        FirefoxOptions fOpt = new FirefoxOptions();
        fOpt.setCapability("Browser","firefox");
        driver = new RemoteWebDriver(new URL(node),fOpt);
        driver.navigate().to(url);
        System.out.println("Firefox output: " + driver.getTitle());
        Thread.sleep(3000);
        driver.quit();
    }
/*    @Test(enabled=false)
    public void ieTest() throws MalformedURLException, InterruptedException {
        String url = "https://www.gmail.com";
        String node = "http://localhost:4444/wd/hub";
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability("ignoreProtectedModeSettings", true);
        dc.setCapability("ie.ensureCleanSession", true);
        dc.setCapability("enableElementCacheCleanup", true);
        dc.setCapability("ignoreZoomSetting", true);
        driver = new RemoteWebDriver(new URL(node),dc);
        driver.navigate().to(url);
        System.out.println("ie output: " + driver.getTitle());
    }*/
    @Test
    public static void edgeTest() throws MalformedURLException, InterruptedException {
        EdgeOptions opt = new EdgeOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--headless");
        opt.addArguments("--disable-dev-shm-usage");
        URL url = new URL("http://10.50.95.121:8082/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url,opt);
        driver.get("https://www.google.com/");
        System.out.println("Edge output: "+driver.getTitle());
        driver.quit();
    }
}
