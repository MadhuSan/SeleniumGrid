package standaloneContainer;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeStandaloneContainer {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        EdgeOptions opt = new EdgeOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--headless");
        opt.addArguments("--disable-dev-shm-usage");
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url,opt);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
}
}
