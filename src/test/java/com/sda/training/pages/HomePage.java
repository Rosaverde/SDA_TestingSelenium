package com.sda.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private static String HOMEPAGE_URL = "http://automationpractice.com/";

    @FindBy(how = How.CLASS_NAME, using = "login")
    WebElement topMenuSignInButton;

    @FindBy(how = How.ID, using = "homepage-slider")
    WebElement homepageSlider;

    public void openHomePage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(homepageSlider));
    }

    public void clickSignInButtonOnTopMenu() {
        topMenuSignInButton.click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(homepageSlider));
    }

}
