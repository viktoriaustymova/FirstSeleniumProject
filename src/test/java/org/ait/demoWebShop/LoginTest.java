package org.ait.demoWebShop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(text(),'Log in')]"))){
            driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
        }
        driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
    }

    @Test
    public void LogInTest(){
        driver.findElement(By.xpath("//input[@id='Email']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).clear();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Alex55@gm.com");
        driver.findElement(By.xpath("//input[@id='Password']")).click();
        driver.findElement(By.xpath("//input[@id='Password']")).clear();
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("User1234!");
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(text(),'Log out')]")));
    }
}
