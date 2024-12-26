package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

public class Cart {

  private LoginPage loginPage;
  private HomePage homePage;
  private int itemCart;

  public Cart() {
  }

  @Dado("que estou logado na home Swag Labs")
  public void loggedInOnSwagLabsHomePage() {
    loginPage = new LoginPage();
    homePage = loginPage.formLogin("standard_user", "secret_sauce");
  }

  @Quando("acesso a página de produtos adicionando itens ao carrinho")
  public void accessProductPageAndAddItemsToCart() {
     itemCart = homePage.addItems();
  }

  @Entao("vejo os itens adicionados no carrinho")
  public void verifyItemsAddedToCart() {
    Assert.assertEquals("O carrinho não contém o número esperado de itens.", 2, itemCart);
  }
}
