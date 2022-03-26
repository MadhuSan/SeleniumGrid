package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SetUpDockerGrid {
    public static WebDriver driver;

    @BeforeTest
    public void startDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start Start-DockerGrid.bat");
        Thread.sleep(15000);
    }

    @Test
    public void chromeTest() throws MalformedURLException, InterruptedException {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--headless");
        opt.addArguments("--disable-dev-shm-usage");
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, opt);
        driver.get("https://www.facebook.com/");
        System.out.println("Chrome output: "+driver.getTitle());
        driver.quit();
    }
    @Test
    public void fireFoxTest() throws MalformedURLException, InterruptedException {
        String url = "https://www.gmail.com";
        String node = "http://localhost:4444/wd/hub";
        FirefoxOptions fOpt = new FirefoxOptions();
        fOpt.setCapability("Browser","firefox");
        driver = new RemoteWebDriver(new URL(node),fOpt);
        driver.navigate().to(url);
        System.out.println("Firefox output: " + driver.getTitle());
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public static void edgeTest() throws MalformedURLException, InterruptedException {
        EdgeOptions opt = new EdgeOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--headless");
        opt.addArguments("--disable-dev-shm-usage");
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url,opt);
        driver.get("https://www.google.com/");
        System.out.println("Edge output: "+driver.getTitle());
        driver.quit();
    }

    @AfterTest
    public void stopDockerGrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start Stop-DockerGrid.bat");
        Thread.sleep(15000);

        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
    }


}
