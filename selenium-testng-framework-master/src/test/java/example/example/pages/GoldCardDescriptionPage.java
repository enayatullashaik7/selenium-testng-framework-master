package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoldCardDescriptionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Demandez Votre Carte')]")
    private WebElement demandezVotreCarteButton;

    public GoldCardDescriptionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
        PageFactory.initElements(driver, this);
    }

    public void clickDemandezVotreCarteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(demandezVotreCarteButton)).click(); // Add explicit wait
    }
}