package utils;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverConfig {
  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.saucedemo.com/");
    }
    return driver;
  }

  public static void closeDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}

