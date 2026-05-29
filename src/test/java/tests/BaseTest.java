package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;

import java.nio.file.Paths;
import java.time.Duration;

public abstract class BaseTest {
    protected static final String URL_BASE = Paths.get("src", "test", "html", "desafio_final_selenium_java.html").toAbsolutePath().toUri().toString();
    protected WebDriver driver;

    @BeforeEach
    public void iniciarDriver() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void finalizarDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected LoginPage abrirLoginPage() {
        LoginPage loginPage = new LoginPage(driver, URL_BASE);
        loginPage.open();
        return loginPage;
    }

    protected void esperar(long milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    protected String aceitarAlerta() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String texto = alert.getText().trim();
        alert.accept();
        return texto;
    }
}