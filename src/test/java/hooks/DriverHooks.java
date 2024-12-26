package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.WebDriverConfig;

public class DriverHooks {
  @Before
  public void setupDriver() {
    WebDriverConfig.getDriver();
  }

  @After
  public void tearDownDriver() {
    WebDriverConfig.closeDriver();
  }
}
