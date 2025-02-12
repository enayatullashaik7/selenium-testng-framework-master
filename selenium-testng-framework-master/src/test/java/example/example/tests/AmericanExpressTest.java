package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class AmericanExpressTest {

    private WebDriver driver;
    private FRHomePage frHomePage;
    private FRAllCardsPage frAllCardsPage;
    private GoldCardDescriptionPage goldCardDescriptionPage;
    private UserDetailsPage userDetailsPage;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:Program Files/Chromedriver/chromedriver.exe"); 

        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize Page Objects
        frHomePage = new FRHomePage(driver);
        frAllCardsPage = new FRAllCardsPage(driver);
        goldCardDescriptionPage = new GoldCardDescriptionPage(driver);
        userDetailsPage = new UserDetailsPage(driver);
    }

    @Test
    public void testAmericanExpressWorkflow() {
        // Step 1: Open FR Homepage
        frHomePage.navigateToHomePage();

        // Step 2: Click on "Cartes American Express"
        frHomePage.clickCartesLink();

        // Step 3: Click on "En Savior Plus" under "Cartes Gold American Express"
        frAllCardsPage.clickEnSavoirPlusLink();

        // Step 4: Click on "Demandez Votre Carte"
        goldCardDescriptionPage.clickDemandezVotreCarteButton();

        // Step 5: Fill in junk data
        userDetailsPage.fillUserDetails("TestFirstName", "TestLastName", "test@example.com", "1234567890");

        // Step 6: Click on "Sauvegarder et Continuer"
        userDetailsPage.clickSaveAndContinue();

        // Step 7: Verify basic user validations (e.g., error messages)
        Assert.assertTrue(userDetailsPage.isErrorMessageDisplayed(), "Validation error message is not displayed");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}