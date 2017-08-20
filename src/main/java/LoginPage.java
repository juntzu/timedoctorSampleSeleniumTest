import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.rmi.runtime.Log;

/**
 * Created by Chris on 20/08/2017.
 */
public class LoginPage {

            By email = By.id("email"),
            password = By.id("password"),
            signIn = By.id("signinFormButton"),
            goToDashBoard = By.id("goto-dashboard");

            String url = "https://login.timedoctor.com/v2/login.php";
            WebDriver driver;
            LoginPage(WebDriver driver){this.driver = driver;}

            public void goTo(){
                driver.get(url);
                System.out.println("Loaded url "+driver.getCurrentUrl());
            }

            public boolean login(String userName, String password){
                System.out.println("Typing email "+userName);
                driver.findElement(email).sendKeys(userName);
                System.out.println("Typing password "+password);
                driver.findElement(this.password).sendKeys(password);

                System.out.println("Clicking sign in");
                driver.findElement(signIn).click();
                System.out.println("Loaded url "+driver.getCurrentUrl());
                System.out.println("Clicking go to dashboard");
                driver.findElement(goToDashBoard).click();
                System.out.println("Loaded url "+driver.getCurrentUrl());

                return true;
            }
}
