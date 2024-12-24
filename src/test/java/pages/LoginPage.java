package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
  private WebDriver driver;

  private By userField = By.id("user-name");
  private By passwordField = By.id("password");
  private By loginButton = By.id("login-button");

  private By titleLocator = By.cssSelector("[data-test='title']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void formLogin(String user, String password) {
    driver.findElement(userField).sendKeys(user);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();

  }

  public Boolean validatePage(){
    //TODO CONTINUAR VALIDAÇÃO DAQUI
//    return driver.findElement(titleLocator).getText().equals("Anderson");
      WebElement titleElement = driver.findElement(titleLocator);
      if (titleElement.isDisplayed()) {
        String titleText = titleElement.getText();
        return titleText.equals("xpto");
      } else {
        System.out.println("Elemento não visível!");
        return false;
      }
  }
}
