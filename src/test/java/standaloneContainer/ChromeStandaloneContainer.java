package standaloneContainer;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeStandaloneContainer {
    public static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--headless");
        opt.addArguments("--disable-dev-shm-usage");
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, opt);
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
