import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Chris on 20/08/2017.
 */
public class LoginTest {

    DriverFactory factory = new DriverFactory();
    SignUp signUp;

    @Before
    public void start(){
        signUp = new SignUp(factory.getDriver());
        signUp.goTo();

        if(signUp.driver.findElements(By.xpath("//*[contains(text(), 'IMPROVE ME')]")).isEmpty()){
            signUp.driver.findElements(By.xpath("//*[contains(text(), 'Yes')]")).get(0).click();
            signUp.driver.findElements(By.xpath("//*[contains(text(), 'Yes')]")).get(0).click();
            signUp.driver.findElements(By.xpath("//*[contains(text(), 'Yes')]")).get(0).click();

        }
        else{
            signUp.driver.findElements(By.xpath("//*[contains(text(), 'IMPROVE ME')]")).get(0).click();
        }
    }
    @After
    public void close() throws IOException {
        signUp.close();
    }

    @Test
    public void ValidUserCanSignupSuccessfully() throws InterruptedException {
        signUp.getElement(Elem.TESTITMYSELF).click();
        signUp.getElement(Elem.CONTINUE).click();
        signUp.getElement(Elem.NAME).sendKeys("TEST NAME");
        signUp.getElement(Elem.EMAIL).sendKeys(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"@doesnotwork.ac.uk");
        signUp.getElement(Elem.PASSWORD).sendKeys("PASSWORD");
        signUp.getElement(Elem.TESTITOUT).click();
        assertTrue(signUp.signUpSuccess());
    }


    @Test
    public void MissingPasswordUserCannotSignupSuccessfully() throws InterruptedException {
        signUp.getElement(Elem.TESTITMYSELF).click();
        signUp.getElement(Elem.CONTINUE).click();
        signUp.getElement(Elem.NAME).sendKeys("TEST NAME");
        signUp.getElement(Elem.EMAIL).sendKeys(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"@doesnotwork.ac.uk");
        signUp.getElement(Elem.TESTITOUT).click();
        assertFalse(signUp.signUpSuccess());
    }

    @Test
    public void MissingNameUserCannotSignupSuccessfully() throws InterruptedException {
        signUp.getElement(Elem.TESTITMYSELF).click();
        signUp.getElement(Elem.CONTINUE).click();
        signUp.getElement(Elem.EMAIL).sendKeys(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"@doesnotwork.ac.uk");
        signUp.getElement(Elem.PASSWORD).sendKeys("PASSWORD");
        signUp.getElement(Elem.TESTITOUT).click();
        assertFalse(signUp.signUpSuccess());
    }

    @Test
    public void MissingEmailUserCannotSignupSuccessfully() throws InterruptedException {
        signUp.getElement(Elem.TESTITMYSELF).click();
        signUp.getElement(Elem.CONTINUE).click();
        signUp.getElement(Elem.NAME).sendKeys("TEST NAME");
        signUp.getElement(Elem.PASSWORD).sendKeys("PASSWORD");
        signUp.getElement(Elem.TESTITOUT).click();
        assertFalse(signUp.signUpSuccess());
    }

}
