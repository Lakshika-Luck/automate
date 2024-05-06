package Sample_App2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LayupSignup {
    public static void main(String[] args) {
        // Set the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "D:\\Layup\\Automation\\edgedriver_win64\\msedgedriver.exe");

        // Create a new instance of the EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to the signup page
        driver.get("https://www.getsal.com/index.php?site=playgroundqe");

        // Find the sign-up link and click it
        WebElement btnloginButton = driver.findElement(By.id("btnFormLogin"));
        btnloginButton.click();

        // Introduce a pause to observe the page transition
        sleep(5000); // 5 seconds pause

        WebElement signupLink = driver.findElement(By.className("SignUpLink"));
        signupLink.click();

        // Use explicit waits for form elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Find the registration form elements with explicit waits
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        WebElement fullNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signupPassword")));
        WebElement reenterPasswordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signupReenterPassword")));

        // Enter the credentials
        emailField.sendKeys("lakshikaautomationuser8@gmail.com");
        fullNameField.sendKeys("LuckAutomationuser8");
        passwordField.sendKeys("Layup1234567890123!");
        reenterPasswordField.sendKeys("Layup1234567890123!");

        // Click the signUp button
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signupSignUp")));
        signupButton.click();

        // Introduce a pause to observe the result
        sleep(5000); // 5 seconds pause

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.getsal.com/index.php?site=playgroundqe#")) {
            System.out.println("Sign Up successful!");
        } else {
            System.out.println("Sign Up failed. Redirected to: " + currentUrl);
        }

        // Click the cancel button
        WebElement cancelBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("cancel")));
        cancelBtn.click();

        // Introduce a pause to observe the page transition
        sleep(5000); // 5 seconds pause

        // Navigate to the login page
        driver.get("https://www.getsal.com/index.php?site=playgroundqe");
        btnloginButton = driver.findElement(By.id("btnFormLogin"));
        btnloginButton.click();

        // Introduce a pause to observe the page transition
        sleep(5000); // 5 seconds pause

        // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.name("username"));
        passwordField = driver.findElement(By.name("password"));

        // Enter the credentials
        usernameField.sendKeys("layup_admin");
        passwordField.sendKeys("AdminLay#123");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.name("loginBttn"));
        loginButton.click();

        // Introduce a pause to observe the result
        sleep(5000); // 5 seconds pause

        // Check if login was successful
        currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.getsal.com/admin_dashboard.php?site=playgroundqe")) {
            System.out.println("Second Login Confirmed!");
        } else {
            System.out.println("Second Login Failed. Redirected to: " + currentUrl);
        }

        // Close the browser
        driver.quit();
    }

    // Method to introduce a pause
    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
