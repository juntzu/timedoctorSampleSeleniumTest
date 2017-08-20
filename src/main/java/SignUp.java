import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chris on 20/08/2017.
 */
public class SignUp {

    String url = "https://www.timedoctor.com/";

    By testItMyself = By.id("self");
    By inviteMyTeam = By.id("myteam");
    By con = By.id("continue");
    By name = By.id("nameField");
    By email = By.id("email");
    By password = By.id("password");
    By toolTip = By.className("tooltip-inner");
    By testItOut = By.id("getStarted");



    Map<Elem, By> map = new HashMap<Elem, By>();

    static int count = 0;
    public void close() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/target/screenshots/test"+(++count)+".png"));
        driver.quit();
    }




            WebDriver driver;
            SignUp(WebDriver driver){this.driver = driver;
                map.put(Elem.TESTITMYSELF, testItMyself);
                map.put(Elem.INVITEMYTEAM, inviteMyTeam);
                map.put(Elem.CONTINUE, con);
                map.put(Elem.NAME, name);
                map.put(Elem.EMAIL, email);
                map.put(Elem.PASSWORD, password);
                map.put(Elem.TOOLTIP, toolTip);
                map.put(Elem.TESTITMYSELF, testItMyself);
                map.put(Elem.TESTITOUT,testItOut);
            }

            public void goTo(){
                driver.get("http://www.google.com");
                driver .manage().window().setSize(new Dimension(1000   , 1500));
                addMainContentCooke();
                driver.get(url);


                System.out.println("Loaded url "+driver.getCurrentUrl());
            }

            public void addMainContentCooke(){

               // System.Net.Cookie(driver.Manage().Cookies.AllCookies[i].Name, driver.Manage().Cookies.AllCookies[i].Value, driver.Manage().Cookies.AllCookies[i].Path, driver.Manage().Cookies.AllCookies[i].Domain);
                Cookie ck = new Cookie("page_cache", "main-content%7Cyes%7C", "www.timedoctor.com","/",new Date());
                driver.manage().addCookie(ck);
            }

            public WebElement getElement(Elem name){
                return driver.findElement(map.get(name));
            }

            public boolean signUpSuccess(){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                 return !driver.findElements(By.xpath("//*[contains(text(), 'Time Doctor Demo')]")).isEmpty();
            }

}
