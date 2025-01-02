package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import lombok.extern.slf4j.Slf4j;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import utils.WebDriverConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class Payment {
  private LoginPage loginPage;

  private HomePage homePage;

  private PaymentPage paymentPage;

  private String orderConfirmation;

  @Dado("que estou logado na home")
  public void que_estou_logado_na_home() {
    log.info("Iniciando step de pagamento");
    loginPage = new LoginPage();
    loginPage.formLogin("standard_user","secret_sauce");
    homePage = loginPage.getDriver();
  }

  @Dado("adicino itens ao carrinho")
  public void adicino_itens_ao_carrinho() {
    log.info("Iniciando step de pagamento para fechar pagamento");
    homePage.addItems();
    paymentPage = homePage.getDriver();
  }

  @Quando("realizo o pagamento")
  public void realizo_o_pagamento() {
    log.info("Pagamento feito");
    orderConfirmation = paymentPage.proceedToPayment();
  }

  @Entao("vejo a mensagem de confirmação {string}")
  public void vejo_a_mensagem_de_confirmação(String message) {
    log.info("Confirmação do pedido");
    assertEquals(message, orderConfirmation);
//    WebDriverConfig.closeDriver();
  }
}
