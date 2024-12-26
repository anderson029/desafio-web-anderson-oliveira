package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
  private LoginPage loginPage;
  @Dado("que estou na página de login da Swag Labs")
  public void loginPage() {
    loginPage = new LoginPage();
  }
  @Quando("insiro o usuário {string} e a senha {string}")
  public void inputCredentials(String user, String password) {
    loginPage.formLogin(user, password);

  }
  @Entao("devo ver home de produtos")
  public void devo_ver_home_de_produtos() {
    assertTrue("Título incorreto.", loginPage.isTitleCorrect());
  }
}
