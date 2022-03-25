package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxTest {
    public static WebDriver driver;
    @Test
    public void fireFoxTest() throws MalformedURLException, InterruptedException {
        String url = "https://www.gmail.com";
        String node = "http://10.50.89.180:8081/wd/hub";
        FirefoxOptions fOpt = new FirefoxOptions();
        fOpt.setCapability("Browser","firefox");
        driver = new RemoteWebDriver(new URL(node),fOpt);
        driver.navigate().to(url);
        Thread.sleep(5000);
        driver.quit();
    }
}
