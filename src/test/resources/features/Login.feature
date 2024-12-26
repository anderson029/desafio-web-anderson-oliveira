#language: pt

Funcionalidade: Login de usuário
  Eu como usuário do e-commerce
  Quero realizar login
  Para visualizar os produtos disponíveis

Cenário: Login com credenciais válidas
  Dado que estou na página de login da Swag Labs
  Quando insiro o usuário "standard_user" e a senha "secret_sauce"
  Então devo ver home de produtos
  E realizo o logout

Esquema do Cenario: Login com credenciais incorretas
  Dado que estou na página de login da Swag Labs
  Quando insiro o usuário "<username>" e a senha "<password>"
  Então devo ver a mensagem "<message>" de erro

  Exemplos:
    | username        | password     | message                                                                   |
    | Xpto            | secret_sauce | Epic sadface: Username and password do not match any user in this service |
    | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
    | standard_user   | xpto         | Epic sadface: Username and password do not match any user in this service |
    |                 |              | Epic sadface: Username is required                                        |
