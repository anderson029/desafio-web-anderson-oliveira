#language: pt

  @Smoke
  Funcionalidade: Fazer pagamento com itens escolhidos
    Eu como usuário do e-commerce
    Quero realizar pagamento dos itens do carrinho
    Para garantir que minha entrega seja feita.

  Cenário: Fazer pagamento com sucesso
    Dado que estou logado na home
    E adicino itens ao carrinho
    Quando realizo o pagamento
    Então vejo a mensagem de confirmação "Thank you for your order!"