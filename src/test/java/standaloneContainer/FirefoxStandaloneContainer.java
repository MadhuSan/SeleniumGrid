package standaloneContainer;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxStandaloneContainer {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        FirefoxOptions fopt =new FirefoxOptions();
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url,fopt);
        driver.get("https://www.gmail.com");
        System.out.println("Firefox output: " + driver.getTitle());
        Thread.sleep(3000);
        driver.quit();
    }

}
