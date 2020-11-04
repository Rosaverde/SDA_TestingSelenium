package com.sda.training.pages;

import com.sda.training.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public final RemoteWebDriver driver;

    public BasePage() {
        this.driver = DriverManager.DRIVER;
        PageFactory.initElements(this.driver, this);
    }
}
