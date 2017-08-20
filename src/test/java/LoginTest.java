import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Chris on 20/08/2017.
 */
public class LoginTest {

    DriverFactory factory = new DriverFactory();

    @Test
    public void ValidUserValidPasswordCanLoginSuccessfully(){
        LoginPage loginPage = new LoginPage(factory.getDriver());
        loginPage.goTo();
        assertTrue(loginPage.login("chris.bro184@gmail.com", "passwordtest"));
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void InvalidUserValidPassCannotLoginSuccessfully(){
        LoginPage loginPage = new LoginPage(factory.getDriver());
        loginPage.goTo();
        loginPage.login("invalid", "passwordtest");
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void ValidUserInvValidPassCannotLoginSuccessfully(){
        LoginPage loginPage = new LoginPage(factory.getDriver());
        loginPage.goTo();
        loginPage.login("chris.bro184@gmail.com", "invalid");
    }
}
