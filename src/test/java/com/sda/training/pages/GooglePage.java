package com.sda.training.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends BasePage {

    private static String GOOGLE_URL = "https://www.google.com/";

    @FindBy(how = How.ID, using = "introAgreeButton")
    WebElement agreeButton;

    @FindBy(how = How.NAME, using = "q")
    WebElement searchField;

    @FindBy(how = How.ID, using = "rcnt")
    WebElement resultsPart;

    public void openGooglePage() {
        driver.get(GOOGLE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchField));
    }

    public void closeFrame() {
        driver.switchTo().frame(0);
        agreeButton.click();
        driver.switchTo().defaultContent();
    }

    public void searchInGoogle(String searchPhrase) {
        searchField.sendKeys(searchPhrase);
        searchField.sendKeys(Keys.ENTER);
    }

    public void verifyIfResultsAreVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(resultsPart));
    }
}
