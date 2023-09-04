package org.ait.demoWebShop;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(text(),'Log in')]"))){
            driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
        }
        driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).clear();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Alex55@gm.com");
        driver.findElement(By.xpath("//input[@id='Password']")).click();
        driver.findElement(By.xpath("//input[@id='Password']")).clear();
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("User1234!");
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]")).click();
    }

    @Test
    public void addItemToCart(){
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();

        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientName']")).click();
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientName']")).clear();
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientName']")).sendKeys("User");

        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientEmail']")).click();
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='giftcard_2_RecipientEmail']")).sendKeys("User@gm.com");

        driver.findElement(By.xpath("//input[@id='giftcard_2_SenderName']")).click();
        driver.findElement(By.xpath("//input[@id='giftcard_2_SenderName']")).clear();
        driver.findElement(By.xpath("//input[@id='giftcard_2_SenderName']")).sendKeys("Alex");

        driver.findElement(By.xpath("//input[@id='giftcard_2_SenderEmail']")).click();
        driver.findElement(By.xpath("//input[@id='giftcard_2_SenderEmail']")).clear();
        driver.findElement(By.xpath("//input[@id='giftcard_2_SenderEmail']")).sendKeys("Alex55@gm.com");

        driver.findElement(By.xpath(" //input[@id='add-to-cart-button-2']")).click();

        driver.findElement(By.xpath(" //body/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();

        isElementPresent(By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]"));
    }


}
