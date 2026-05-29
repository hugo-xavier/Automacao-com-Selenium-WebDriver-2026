# Automacao-com-Selenium-WebDriver-2026

Projeto de automacao de testes web com Selenium WebDriver + Java + JUnit 5, utilizando o padrao Page Object.

## Objetivo

Automatizar fluxos principais e de excecao do sistema HTML de treino, com foco em validacoes e organizacao de codigo.

## Tecnologias

- Java 25
- Selenium WebDriver 4.44.0
- JUnit Jupiter 5.12.2
- Maven
- Google Chrome + ChromeDriver

## Estrutura do projeto

```text
src/test/java/
	pages/
		LoginPage.java
		PromocaoPage.java
		CadastrarPetPage.java
	tests/
		BaseTest.java
		LoginPet.java
		VerPromocao.java
		CadastrarPet.java

src/test/resources/images/
	PugMeg.jpg
```

## Padrao adotado

- Page Object para centralizar mapeamento e acoes das telas.
- BaseTest para reduzir repeticao (driver, URL base, setup/teardown, utilitarios comuns).
- Testes independentes com ciclo completo de abertura/fechamento do navegador por teste.

## Cenarios automatizados

### Login

1. Login invalido
2. Login valido
3. Logout apos login

### Promocao

4. Ver promocao com validacao de alerta e mensagem em tela

### Cadastro de pet

5. Tentativa de salvar sem campos obrigatorios (validacao de alerta)
6. Limpar formulario e validar que campos voltaram ao estado vazio
7. Cadastro com sucesso e validacao da mensagem final

## Pre-requisitos

- Java configurado no ambiente
- Maven instalado
- Google Chrome instalado

## Como executar

No terminal, na raiz do projeto:

```bash
mvn test
```

Para executar uma classe especifica:

```bash
mvn -Dtest=tests.CadastrarPet test
```

## Arquivo HTML do PetShop

Arquivo utilizado nos testes:

- Caminho local: C:/Users/hlimax/Documents/Selenium/desafio_final_selenium_java.html

Este arquivo contem os fluxos validados pela automacao:

- Login (valido e invalido)
- Promocao
- Cadastro de pet (salvar, limpar e obrigatoriedade de campos)

URL usada pela suite de testes:

- file:///C:/Users/hlimax/Documents/Selenium/desafio_final_selenium_java.html

## Observacoes

- O arquivo HTML utilizado nos testes esta configurado via URL local na classe base.
- A imagem usada no upload do cadastro fica em `src/test/resources/images/PugMeg.jpg`.
