package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverConfig;

public class LoginPage {
  private WebDriver driver;

  private By userField = By.id("user-name");
  private By passwordField = By.id("password");
  private By loginButton = By.id("login-button");

  private By titleLocator = By.cssSelector("[data-test='title']");

  public LoginPage() {
    this.driver = WebDriverConfig.getDriver();
  }

  public void formLogin(String user, String password) {
    driver.findElement(userField).sendKeys(user);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();

  }

  public Boolean isTitleCorrect(){
      WebElement titleElement = driver.findElement(titleLocator);
      String titleText = titleElement.getText();
      return titleText.equals("Products");
  }
}