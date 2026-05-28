package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final String url;

    private final By usernameInput = By.id("login-username");
    private final By passwordInput = By.id("login-password");
    private final By submitButton = By.id("login-submit");
    private final By errorMessage = By.id("login-error");
    private final By successMessage = By.id("login-success");
    private final By logoutButton = By.id("logout-button");

    public LoginPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    public void open() {
        driver.get(url);
    }

    public void typeUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickSubmit();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText().trim();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText().trim();
    }

    public String getRedirectHeadingH1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText().trim();
    }

    public String getRedirectHeadingH2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2"))).getText().trim();
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
