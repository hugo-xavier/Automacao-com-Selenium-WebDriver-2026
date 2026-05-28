package tests;

import org.junit.jupiter.api.Test;

import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPet extends BaseTest {

    @Test
    public void testeLoginInvalido() {
        LoginPage loginPage = abrirLoginPage();
        loginPage.loginAs("admin", "1234567");

        assertEquals("❌ Usuário ou senha inválidos. Use admin / 123456", loginPage.getErrorMessage());
    }

    @Test
    public void testeLoginValido() {
        LoginPage loginPage = abrirLoginPage();
        loginPage.loginAs("admin", "123456");

        assertEquals("✅ Login realizado! Redirecionando...", loginPage.getSuccessMessage());
        assertEquals("🐾 PetShop QA Center", loginPage.getRedirectHeadingH1());
    }

    @Test
    public void testeLogout() {
        LoginPage loginPage = abrirLoginPage();
        loginPage.loginAs("admin", "123456");

        assertEquals("✅ Login realizado! Redirecionando...", loginPage.getSuccessMessage());
        
        loginPage.clickLogout();

         assertEquals("🐕 Acesso ao Sistema", loginPage.getRedirectHeadingH2());

    }
    
}
                                                                                