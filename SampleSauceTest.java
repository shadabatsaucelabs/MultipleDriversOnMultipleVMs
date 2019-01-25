import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SampleSauceTest {

  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
  
  public static void main(String[] args) throws Exception {
	  
    /**
	     * Set Desired Capabilities for Virtual Machine 1
	 */

    DesiredCapabilities caps1 = DesiredCapabilities.chrome();
    caps1.setCapability("platform", "Windows 10");
    caps1.setCapability("version", "latest");
    
    /**
         * Set Desired Capabilities for Virtual Machine 2
    */
    
    DesiredCapabilities caps2 = DesiredCapabilities.chrome();
    caps2.setCapability("platform", "Windows 8.1");
    caps2.setCapability("version", "latest");
    
    /**
          * Set Desired Capabilities for Virtual Machine 3
    */
    
    DesiredCapabilities caps3 = DesiredCapabilities.firefox();
    caps3.setCapability("platform", "Windows 8");
    caps3.setCapability("version", "64.0");
    
    /**
     * Initiate Drivers
     */

    WebDriver driver1 = new RemoteWebDriver(new URL(URL), caps1);
    WebDriver driver2 = new RemoteWebDriver(new URL(URL), caps2);
    WebDriver driver3 = new RemoteWebDriver(new URL(URL), caps3);

    
    /**
     * Run Driver1 on Virtual machine 1 -> Goes to Sauce Lab's guinea-pig page and prints title
     */

    driver1.get("https://saucelabs.com/test/guinea-pig");
    System.out.println("title of page is: " + driver1.getTitle());
    
    /**
     * Run Driver2 on Virtual machine 2 -> Goes to Sauce Lab's guinea-pig page and prints title
     */

    driver2.get("https://saucelabs.com/test/guinea-pig");
    System.out.println("title of page is: " + driver2.getTitle());
    
    /**
     * Run Driver3 on Virtual machine 3 -> Goes to Sauce Lab's guinea-pig page and prints title
     */
    
    driver3.get("https://saucelabs.com/test/guinea-pig");
    System.out.println("title of page is: " + driver3.getTitle());
    
    /**
     * Quit Drivers
     */

    driver1.quit();
    driver2.quit();
    driver3.quit();
    
  }
}
