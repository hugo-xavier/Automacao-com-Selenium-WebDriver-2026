package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.LoginPage;
import pages.PromocaoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerPromocao extends BaseTest {
	private LoginPage loginPage;
	private PromocaoPage promocaoPage;

	@BeforeEach
	public void iniciarTesteComLogin() {
		loginPage = abrirLoginPage();
		promocaoPage = new PromocaoPage(driver);
		loginPage.loginAs("admin", "123456");
	}

    @Test
    public void testeVerPromocao() {
		promocaoPage.clickVerPromocao();
		String alertaPromocao = aceitarAlerta();
		assertEquals("🎁 Promoção liberada: 20% OFF em banho completo!", alertaPromocao);
		assertEquals("🎉 Promoção especial: banho completo com 20% OFF + brinde!", promocaoPage.getMensagemPromocao());
    }
}
