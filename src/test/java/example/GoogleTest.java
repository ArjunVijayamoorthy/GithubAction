package example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class GoogleTest {
     WebDriver driver;
    @BeforeClass
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }
    @Test
    public void testGoogleTitle() {
        // Open Google
        driver.get("https://www.google.com");
        // Verify page title
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Google", "Page title does not match");
    }
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit(); // Close browser
        }
    }
}
