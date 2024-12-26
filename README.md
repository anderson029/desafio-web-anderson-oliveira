
# Desafio teste automação Web

Este projeto tem como objetivo validar as funcionalidades de login, adicionar itens ao carrinho e validar pagamento.
## 🔧 [ Requisitos ]

Para executar essa automação é necessário ter instalado:

Java 17 ou superior.

Maven.

## 🚀Tecnologias Utilizadas

Java 17: Versão do Java utilizada no projeto.

Cucumber: Framework para testes de comportamento (BDD).

JUnit 5: Framework para execução de testes unitários e integração.

Java Faker: Framework para gerar dados fakes.

Selenium: Realiza o comportamento do navegador (nesse projeto, configurado para chromedriver)


## ⚙️ Começando

1. Clone o repositório: git clone <url-do-repositorio>
2. Compile o projeto e baixe as dependências: mvn clean install
3. Para rodar os testes, utilize o seguinte comando: mvn test

___________________IntelliJ IDEA___________________

1. Abra o IntelliJ IDEA.
2. Selecione "Open" e escolha a pasta do projeto.
3. O IntelliJ irá detectar automaticamente o projeto Maven e baixar as dependências.
4. Para rodar os testes, clique com o botão direito na classe de teste ou no arquivo .feature do Cucumber e selecione Run.


## 📊 Reports - (em desenvolvimento)
Os relatórios de teste do Cucumber serão gerados automaticamente na pasta target/cucumber-reports.