package org.ait.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        //maximize browser window
        driver.manage().window().maximize();
        //set implicit timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void findElementTest(){
        //find element by tag name
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());
        //find list of elements
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
        //find element by id
        WebElement element1 = driver.findElement(By.id("city"));
        //find element by class name
        WebElement element2 = driver.findElement(By.className("input-label"));
        WebElement viewport = driver.findElement(By.name("viewport"));
        //find element by link text
        WebElement let_the_car_work = driver.findElement(By.linkText("Let the car work"));
        //find element by partial link text
        driver.findElement(By.partialLinkText("work"));
    }

    @Test
    public void findElementByCssTest(){
        //WebElement element = driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#city"));
        //class name  -> css (.)
        driver.findElement(By.cssSelector(".input-label"));
        //attr + parameter [attr = 'parameter']
        driver.findElement(By.cssSelector("[name = 'viewport']"));
        //css contains(*)
        driver.findElement(By.cssSelector("[class*='pristine']"));
        //css - start (^)
        driver.findElement(By.cssSelector("[class^='ng']"));
        //css - end on($)
        driver.findElement(By.cssSelector("[class$= 'input']"));
    }

    @Test
    public void findElementXpathTest(){
        // //* [@attr='parameter']
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));
        //find element by id
        driver.findElement(By.xpath("//input[@id = 'city']"));
        driver.findElement(By.xpath("//label[@class = 'input-label']"));
        //text -> xpath /[contains(.,'text')]
        driver.findElement(By.xpath("//h2[contains(.,'Type your data and hit Yalla!')]"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
