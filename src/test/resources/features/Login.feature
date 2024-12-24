#language: pt

Funcionalidade: Login de usuário
  Eu como usuário do e-commerce
  Quero realizar login
  Para visualizar os produtos disponíveis

  Cenário: : Login com credenciais válidas
    Dado que estou na página de login da Swag Labs
    Quando insiro o usuário "standard_user" e a senha "secret_sauce"
    Então devo ver home de produtos
