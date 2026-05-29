package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastrarPetPage {
    private final WebDriver driver;

    private final By openRegisterPageButton = By.id("nav-register");
    private final By petNameInput = By.id("pet-name");
    private final By petOwnerInput = By.id("pet-owner");
    private final By petSpeciesSelect = By.id("pet-species");
    private final By petAgeInput = By.id("pet-age");
    private final By petNotesInput = By.id("pet-notes");
    private final By petVaccinatedCheckbox = By.id("pet-vaccinated");
    private final By petPhotoInput = By.id("pet-photo");
    private final By savePetButton = By.id("save-pet-button");
    private final By petSuccessMessage = By.id("pet-success");
    private final By clearFormButtonBy = By.id("clear-form-button");

    public CadastrarPetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPaginaCadastro() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(openRegisterPageButton)).click();
    }

    public void cadastrarPet(String nome, String dono, String especie, String idade, String caminhoFoto) {
        driver.findElement(petNameInput).sendKeys(nome);
        driver.findElement(petOwnerInput).sendKeys(dono);
        new Select(driver.findElement(petSpeciesSelect)).selectByVisibleText(especie);
        driver.findElement(petAgeInput).sendKeys(idade);
        driver.findElement(petNotesInput).sendKeys("Alergia na pele.");   
        driver.findElement(petVaccinatedCheckbox).click();
        driver.findElement(petPhotoInput).sendKeys(caminhoFoto);
    }

    public void clicarSalvar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(savePetButton)).click();
    }

    public String getMensagemSucessoCadastro() {
        return driver.findElement(petSuccessMessage).getText().trim();
    }

    public void clicarLimpar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clearFormButtonBy)).click();
    }

    public boolean formularioEstaVazio() {
        String nome = driver.findElement(petNameInput).getAttribute("value");
        String dono = driver.findElement(petOwnerInput).getAttribute("value");
        String idade = driver.findElement(petAgeInput).getAttribute("value");
        String observacoes = driver.findElement(petNotesInput).getAttribute("value");
        String foto = driver.findElement(petPhotoInput).getAttribute("value");
        String especieSelecionada = new Select(driver.findElement(petSpeciesSelect)).getFirstSelectedOption().getAttribute("value");
        boolean vacinado = driver.findElement(petVaccinatedCheckbox).isSelected();

        return nome.isEmpty()
                && dono.isEmpty()
                && idade.isEmpty()
                && observacoes.isEmpty()
                && foto.isEmpty()
                && especieSelecionada.isEmpty()
                && !vacinado;
    }
}
