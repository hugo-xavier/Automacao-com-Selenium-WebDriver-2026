package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.CadastrarPetPage;
import pages.LoginPage;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastrarPet extends BaseTest {
	private LoginPage loginPage;
	private CadastrarPetPage cadastrarPetPage;

	@BeforeEach
	public void iniciarTesteComLogin() {
		loginPage = abrirLoginPage();
		cadastrarPetPage = new CadastrarPetPage(driver);
		loginPage.loginAs("admin", "123456");
		esperar(1000);
	}

	@Test
	public void testePreencherCadastroSemSalvar() {
		cadastrarPetPage.abrirPaginaCadastro();
		cadastrarPetPage.clicarSalvar();
		String alertaTexto = aceitarAlerta();
		assertEquals("⚠️ Preencha: Nome do Pet, Dono e Espécie (obrigatórios).", alertaTexto);
	}

    @Test
    public void testeLimparCampos() {
		String caminhoFoto = Paths.get("src", "test", "resources", "images", "PugMeg.jpg").toAbsolutePath().toString();
        cadastrarPetPage.abrirPaginaCadastro();
		cadastrarPetPage.cadastrarPet("Meg", "Hugo", "Cachorro 🐕", "6 anos", caminhoFoto);
        cadastrarPetPage.clicarLimpar();
		assertTrue(cadastrarPetPage.formularioEstaVazio());
    }

    @Test
    public void testePreencherCadastroESalvar() {
        String caminhoFoto = Paths.get("src", "test", "resources", "images", "PugMeg.jpg").toAbsolutePath().toString();
		cadastrarPetPage.abrirPaginaCadastro();
		cadastrarPetPage.cadastrarPet("Meg", "Hugo", "Cachorro 🐕", "6 anos", caminhoFoto);
		cadastrarPetPage.clicarSalvar();
		assertEquals("✅ Pet cadastrado com sucesso!", cadastrarPetPage.getMensagemSucessoCadastro());
	}

}
