package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FRAllCardsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h3[contains(text(), 'Cartes Gold American Express')]/following-sibling::a[contains(text(), 'En Savior Plus')]")
    private WebElement enSavoirPlusLink;

    public FRAllCardsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
        PageFactory.initElements(driver, this);
    }

    public void clickEnSavoirPlusLink() {
        wait.until(ExpectedConditions.elementToBeClickable(enSavoirPlusLink)).click(); // Add explicit wait
    }
}