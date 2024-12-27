package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.WebDriverConfig;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@Slf4j
public class DriverHooks {

  private WebDriver driver;

  @Before
  public void setupDriver() {
    driver = WebDriverConfig.getDriver();
    log.info("Iniciando o WebDriver...");
  }

  @After
  public void captureScreenshotAndCloseDriver(Scenario scenario) throws IOException {
    if (scenario.isFailed()) {
      log.error("Cenário falhou: " + scenario.getName());
    } else {
      log.info("Cenário validado: " + scenario.getName());
    }

    String screenshotName = scenario.getName() + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".png";
    File destFile = Paths.get("screenshots", screenshotName).toFile();

    FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), destFile);

    WebDriverConfig.closeDriver();
    log.info("WebDriver encerrado.");
  }
}
