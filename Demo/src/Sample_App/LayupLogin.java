package Sample_App;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class LayupLogin {
    public static void main(String[] args) throws InterruptedException {

        // Set the path to the EdgeDriver executable
        System.setProperty("web driver.edge.driver", "D:\\Layup\\Automation\\edgedriver_win64\\msedgedriver.exe");

        // Create a new instance of the EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to the login page
        driver.get("https://www.getsal.com/index.php?site=playgroundqe");

        sleep(1000); // 5 seconds pause
        WebElement btnloginButton = driver.findElement(By.id("btnFormLogin"));
        btnloginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement backButton = driver.findElement(By.id("formBack"));
        backButton.click();
/*
        // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Enter the credentials
        usernameField.sendKeys("layup_admin");
        passwordField.sendKeys("AdminLay#123");

        // Find and click the login button
       WebElement loginButton = driver.findElement(By.name("loginBttn"));
       loginButton.click();

        // Check if login was successful
       String currentUrl = driver.getCurrentUrl();
       if (currentUrl.equals("https://www.getsal.com/admin_dashboard.php?site=playgroundqe")) {
           System.out.println("Login successful!");
        } else {
          System.out.println("Login failed. Redirected to: " + currentUrl);
       }

        // Find and click the login button
        WebElement backButton = driver.findElement(By.id("formBack"));
        backButton.click();

    // Check if we are back on the login page
        if (driver.getCurrentUrl().equals("https://www.getsal.com/index.php?site=playgroundqe")) {
            System.out.println("Back button test passed. Returned to the login page.");
        } else {
            System.out.println("Back button test failed. Not returned to the login page.");
        }
    }



        // Close the browser
       // driver.quit();
*/

    }
}
