package online.tekwillacademy;

import online.tekwillacademy.managers.DataGeneratorManager;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.ScrollManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The current url is : " + driver.getCurrentUrl());
        System.out.println("The current page title : " + driver.getTitle());

        WebElement userDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        userDropDownIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerOption.click();

        System.out.println("The current url is : " + driver.getCurrentUrl());
        System.out.println("The current page title : " + driver.getTitle());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("Victor");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Burlaca");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = DataGeneratorManager.getRandomEmail();
        emailInput.sendKeys(emailData);
        System.out.println("Email :" + emailData);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("Password123!");

        WebElement privacyToggle = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        // ScrollManager.scrollToElement(privacyToggle);
        privacyToggle.click();


        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        Thread.sleep(3000);
        continueButton.click();

        System.out.println("The current url is : " + driver.getCurrentUrl());
        System.out.println("The current page title : " + driver.getTitle());
        Thread.sleep(2000);

        continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        continueButton.click();

        System.out.println("The current url is : " + driver.getCurrentUrl());
        System.out.println("The current page title : " + driver.getTitle());

        driver.close();

        driver.quit();

        System.out.println("The test is finish and the driver is closed");
    }
}