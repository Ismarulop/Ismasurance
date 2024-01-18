package com.ismasurance.ismasurance.selenium.suites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AddClaimPage {
    @Autowired
    WebDriver webDriver;

    public void writeInPolicyInput(String policy){
        webDriver.findElement(By.id("policy-input")).sendKeys(policy);

    } public void writeInHandlerInput(String handler){
        webDriver.findElement(By.id("handler-input")).sendKeys(handler);

    } public void writeInInsuredInput(String insured){
        webDriver.findElement(By.id("insured-input")).sendKeys(insured);

    } public void writeInDateInput(String date){
        webDriver.findElement(By.id("claim-date-input")).sendKeys(date);

    }

    public void clickOnAddClaimButton(){
        webDriver.findElement(By.className("add-claim-button")).click();

    }

    public void navigate(){
        webDriver.get("http://localhost:3000/home");

    }
}
