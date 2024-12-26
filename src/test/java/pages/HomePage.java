package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

  private WebDriver driver;
  private By submenu = By.id("react-burger-menu-btn");
  private By logout = By.id("logout_sidebar_link");
  private By backpack = By.id("add-to-cart-sauce-labs-backpack");
  private By bike = By.id("add-to-cart-sauce-labs-bike-light");
  private By cartBadge = By.cssSelector("#shopping_cart_container .shopping_cart_link");

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void logout(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(submenu)).click();
    wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
  }

  public int addItems(){
    driver.findElement(backpack).click();
    driver.findElement(bike).click();

    String badgeText = driver.findElement(cartBadge).getText();
    return Integer.parseInt(badgeText);
  }
}