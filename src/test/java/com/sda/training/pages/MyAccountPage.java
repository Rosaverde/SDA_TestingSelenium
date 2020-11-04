package com.sda.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "info-account")
    private WebElement infoAccountMessage;

    public void verifyIfMyAccountPageIsOpened() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(infoAccountMessage));
    }
}
