package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(xpath = "//button[contains(text(), 'Sauvegarder et Continuer')]")
    private WebElement saveAndContinueButton;

    @FindBy(xpath = "//div[contains(text(), 'Please enter valid data')]")
    private WebElement errorMessage;

    public UserDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
        PageFactory.initElements(driver, this);
    }

    public void fillUserDetails(String firstName, String lastName, String email, String phone) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName); // Add explicit wait
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
    }

    public void clickSaveAndContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton)).click(); // Add explicit wait
    }

    public boolean isErrorMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed(); // Add explicit wait
    }
}