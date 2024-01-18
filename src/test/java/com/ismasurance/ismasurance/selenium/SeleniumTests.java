package com.ismasurance.ismasurance.selenium;

import com.ismasurance.ismasurance.selenium.suites.AddClaimPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SeleniumTests {
    @Autowired
    AddClaimPage addClaimPage;

    @Test
    void navigateToHomePage() throws InterruptedException{
       addClaimPage.navigate();
       addClaimPage.writeInPolicyInput("12345");
       addClaimPage.writeInHandlerInput("Portela Hurtado");
       addClaimPage.writeInInsuredInput("Ana Martinez");
       addClaimPage.writeInDateInput("30/12/2022");
       addClaimPage.clickOnAddClaimButton();

    }
}
