import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

  ChromeOptions chromeOptions = new ChromeOptions();
  WebDriver driver = null;

  @BeforeTest
  public void beforeTest() throws Exception {
    driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
    driver.get("https://in.ebay.com/");
  }

  @Test
  public void testcase_1() throws InterruptedException {
    // Check the title of the page
    String title = driver.getTitle();
    Assert.assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
  }

  @Test
  public void testcase_2() throws InterruptedException {
    // Search for "Apple Watches"
    driver.findElement(By.id("gh-ac")).sendKeys("Apple Watches");
    driver.findElement(By.id("gh-btn")).click();

    // Get the name of the first product
    String firstProduct = driver.findElement(By.xpath("//ul[@id='ListViewInner']/li[1]//h3")).getText();
    Assert.assertEquals(firstProduct, "Apple Watch Series 6 (GPS + Cellular, 40mm) - Space Gray Aluminum Case with Black Sport Band");
  }

  @Test
  public void testcase_3() throws InterruptedException {
    // Search for "Apple Watches"
    driver.findElement(By.id("gh-ac")).sendKeys("Apple Watches");
    driver.findElement(By.id("gh-btn")).click();

    // Get the name of the 10th product
    String tenthProduct = driver.findElement(By.xpath("//ul[@id='ListViewInner']/li[10]//h3")).getText();
    Assert.assertEquals(tenthProduct, "Apple Watch Series 6 (GPS, 40mm) - Gold Aluminum Case with Pink Sand Sport Band");
  }

  @AfterTest
  public void afterTest() {
    driver.quit();
  }
}