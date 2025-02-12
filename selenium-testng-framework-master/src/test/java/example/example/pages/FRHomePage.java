package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FRHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Cartes American Express")
    private WebElement cartesLink;

    public FRHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get("https://www.americanexpress.com/fr-fr/?inav=NavLogo");
    }

    public void clickCartesLink() {
        wait.until(ExpectedConditions.elementToBeClickable(cartesLink)).click(); // Add explicit wait
    }
}