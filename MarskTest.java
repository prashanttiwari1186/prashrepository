package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class MarskTest {



    public static void main(String[] args) {
//initializing the driver from the local machine using chrome driver
//has to provide the path as per the chromedriver exe kept in the machine.

        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
       // ChromeOptions options = new ChromeOptions();
        //options.setBinary("C://Program Files//Google//Chrome//Application//chrome.exe");
        WebDriver driver = new ChromeDriver();

//launch the url
        driver.get("https://blazedemo.com");

//choose source and destination city
        Select from= new Select(driver.findElement(By.name("fromPort")));
        from.selectByValue("Boston");

        Select destination= new Select(driver.findElement(By.name("toPort")));
        destination.selectByValue("London");

//click on searchFlight
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        List<WebElement>chooseflight=driver.findElements(By.xpath("//input[@value='Choose This Flight']"));
        chooseflight.get(1).click();
        //Entering booking form
        driver.findElement(By.id("inputName")).sendKeys("Mark Test");
        driver.findElement(By.id("address")).sendKeys("Pune");
        driver.findElement(By.id("city")).sendKeys("Pune");;
        driver.findElement(By.id("state")).sendKeys("Maharashtra");
        driver.findElement(By.id("zipCode")).sendKeys("232322");
        driver.findElement(By.id("creditCardNumber")).sendKeys("232322");
        driver.findElement(By.id("creditCardMonth")).clear();
        driver.findElement(By.id("creditCardMonth")).sendKeys("02");
        driver.findElement(By.id("creditCardYear")).clear();
        driver.findElement(By.id("creditCardYear")).sendKeys("2021");
        driver.findElement(By.id("nameOnCard")).sendKeys("Mark Test");
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

        String confirmID = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
        System.out.println("your ticket is confirmed with confirm id " + confirmID);
        //Closing browser
        driver.close();











    }

}

