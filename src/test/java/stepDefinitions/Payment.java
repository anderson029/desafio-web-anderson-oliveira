package stepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Payment {
  private LoginPage loginPage;

  private HomePage homePage;

  private PaymentPage paymentPage;

  private String orderConfirmation;

  @Dado("que estou logado na home")
  public void que_estou_logado_na_home() {
    loginPage = new LoginPage();
    homePage = loginPage.formLogin("standard_user","secret_sauce");
  }
  @Dado("adicino itens ao carrinho")
  public void adicino_itens_ao_carrinho() {
    homePage.addItems();
  }

  @Quando("realizo o pagamento")
  public void realizo_o_pagamento() {
    paymentPage.getDriver();
    orderConfirmation = paymentPage.proceedToPayment();
  }
  @Entao("vejo a mensagem de confirmação {string}")
  public void vejo_a_mensagem_de_confirmação(String string) {
//    assertEquals("Texto de confirmação não corresponde", "Thank you for your order!", orderConfirmation);
  }
}
