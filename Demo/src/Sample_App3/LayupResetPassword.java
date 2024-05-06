package Sample_App3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class LayupResetPassword {
    public static void main(String[] args) throws InterruptedException {

        // Set the path to the EdgeDriver executable
        System.setProperty("web driver.edge.driver", "D:\\Layup\\Automation\\edgedriver_win64\\msedgedriver.exe");

        // Create a new instance of the EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to the login page
        driver.get("https://www.getsal.com/index.php?site=playgroundqe");

        WebElement btnloginButton = driver.findElement(By.id("btnFormLogin"));
        btnloginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("btnForgotPassword"));
        loginButton.click();



//enter username and get OTP code to user mobile number
        driver.get("https://www.getsal.com/index.php?site=playgroundqe#");

        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("forgotPassUsername")));
        usernameField.sendKeys("lakshikarasanjali1114@gmail.com");

        WebElement forgotPassSubmit = driver.findElement(By.id("forgotPassSubmit"));
        forgotPassSubmit.click();


        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.getsal.com/admin_dashboard.php?site=playgroundqe")) {
            System.out.println("Success ! An SMS has been sent to your mobile number with the account recovery details.!");
        } else {
            System.out.println("Retry !" + currentUrl);
        }

//enter OTP code to reset password
        driver.get("https://www.getsal.com/index.php?site=playgroundqe#");

        WebElement OTPcodeField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("otp")));
        OTPcodeField.sendKeys("");

        WebElement changePasswordOTPButton = driver.findElement(By.id("changePasswordOTP"));
        changePasswordOTPButton.click();


        currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.getsal.com/admin_dashboard.php?site=playgroundqe")) {
            System.out.println("Success ! Password has been changed.");
        } else {
            System.out.println("Retry the OTP code !" + currentUrl);
        }


        //driver.quit();
    }

    }

