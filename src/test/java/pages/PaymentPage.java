package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverConfig;

public class PaymentPage {
  private WebDriver driver;

  private Faker faker = new Faker();

  private By checkout = By.id("checkout");
  private By firstName = By.id("first-name");
  private By lastName = By.id("last-name");
  private By zipCode = By.id("postal-code");
  private By continueId = By.id("continue");
  private By finish = By.id("finish");

  private By completeHeader = By.cssSelector("h2.complete-header[data-test='complete-header']");

  public PaymentPage() {
    this.driver = WebDriverConfig.getDriver();
  }

  public PaymentPage(WebDriver driver) {
    this.driver = driver;
  }

  public String proceedToPayment() {
    driver.findElement(checkout).click();
    driver.findElement(firstName).sendKeys(faker.name().firstName());
    driver.findElement(lastName).sendKeys(faker.name().lastName());
    driver.findElement(zipCode).sendKeys(faker.address().zipCode());
    driver.findElement(continueId).click();
    driver.findElement(finish).click();
    return driver.findElement(completeHeader).getText();
  }
}