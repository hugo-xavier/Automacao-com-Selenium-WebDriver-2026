package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PromocaoPage {
    private final WebDriver driver;
    private final By promotionButton = By.id("promotion-button");
    private final By promotionMessage = By.id("promotion-message");

    public PromocaoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickVerPromocao() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(promotionButton)).click();
    }

    public String getMensagemPromocao() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(promotionMessage)).getText().trim();
    }
}
