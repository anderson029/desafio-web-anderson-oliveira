package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverConfig;

@Slf4j
public class Login {
  private LoginPage loginPage;
  private HomePage homePage;


  @Dado("que estou na página de login da Swag Labs")
  public void navigateToLoginPage() {
    log.info("Iniciando login...");
    loginPage = new LoginPage();
  }

  @Quando("insiro o usuário {string} e a senha {string}")
  public void enterCredentials(String user, String password) {
    loginPage.formLogin(user, password);
    homePage = loginPage.getDriver();
  }

  @Entao("devo ver home de produtos")
  public void verifyProductHomepage() {
    log.info("Verificando a home...");
    Assertions.assertTrue(loginPage.isTitleCorrect(), "Título incorreto.");
  }

  @Entao("realizo o logout")
  public void logout() {
    log.info("Realizando logout");
    homePage.logout();
//    WebDriverConfig.closeDriver();
  }

  @Entao("devo ver a mensagem {string} de erro")
  public void verifyErrorMessage(String expectedMessage) {
    log.info("Validando mensagem de erro.");
    Boolean isMessageCorrect = loginPage.isErrorMessageDisplayed(expectedMessage);
    Assertions.assertTrue(isMessageCorrect, "A mensagem de erro exibida está incorreta.");
//    WebDriverConfig.closeDriver();
  }
}
