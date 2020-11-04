package com.sda.training.steps;

import com.sda.training.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("---------SCENARIO " + scenario.getName() + " STARTED---------");
        DriverManager.startDriver();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        DriverManager.processExecutedScenario(scenario);
    }
}
