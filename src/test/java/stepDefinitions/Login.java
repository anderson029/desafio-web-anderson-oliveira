package stepDefinitions;

import hooks.DriverHooks;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class Login {
  private LoginPage loginPage;
  private HomePage homePage;

  @Dado("que estou na página de login da Swag Labs")
  public void navigateToLoginPage() {
    loginPage = new LoginPage();
  }
  @Quando("insiro o usuário {string} e a senha {string}")
  public void enterCredentials(String user, String password) {
    homePage = loginPage.formLogin(user, password);
  }
  @Entao("devo ver home de produtos")
  public void verifyProductHomepage() {
    assertTrue("Título incorreto.", loginPage.isTitleCorrect());
  }

  @Entao("realizo o logout")
  public void logout() {
    homePage.logout();
  }

  @Entao("devo ver a mensagem {string} de erro")
  public void verifyErrorMessage(String expectedMessage) {
    Boolean isMessageCorrect = loginPage.isErrorMessageDisplayed(expectedMessage);
    assertTrue("A mensagem de erro exibida está incorreta.", isMessageCorrect);
  }
}
