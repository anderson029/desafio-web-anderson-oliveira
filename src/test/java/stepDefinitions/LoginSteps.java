package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.WebDriverConfig;

public class LoginSteps {
  private WebDriver driver;
  private LoginPage loginPage;
  @Dado("que estou na página de login da Swag Labs")
  public void loginPage() {
    driver = WebDriverConfig.getDriver();
    loginPage = new LoginPage(driver);
  }
  @Quando("insiro o usuário {string} e a senha {string}")
  public void inputCredentials(String user, String password) {
    loginPage.formLogin(user, password);

  }
  @Entao("devo ver home de produtos")
  public void devo_ver_home_de_produtos() {
    loginPage.validatePage();
  }
}
