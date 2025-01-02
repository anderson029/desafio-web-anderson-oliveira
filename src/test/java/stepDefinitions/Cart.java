package stepDefinitions;

import hooks.DriverHooks;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import pages.LoginPage;


@Slf4j
public class Cart {

  private LoginPage loginPage;
  private HomePage homePage;
  private int quantityItem;

  @Dado("que estou logado na home Swag Labs")
  public void loggedInOnSwagLabsHomePage() {
    log.info("Fazendo login...");
    loginPage = new LoginPage();
    loginPage.formLogin("standard_user", "secret_sauce");
    homePage = loginPage.getDriver();
  }

  @Quando("acesso a página de produtos adicionando itens ao carrinho")
  public void accessProductPageAndAddItemsToCart() {
    log.info("retornando a quantidade de itens no carrinho");
    quantityItem = homePage.quantityItemCart();
  }

  @Entao("vejo os itens adicionados no carrinho")
  public void verifyItemsAddedToCart() {
    log.info("Validando quantidade de itens no carrinho.");
    Assertions.assertEquals(2, quantityItem, "O carrinho não contém o número esperado de itens.");
  }
}
