import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Chris on 20/08/2017.
 */
public class DriverFactory {

    String path = System.getProperty("user.dir")+"/target/phantomjs-maven-plugin/phantomjs-1.9.7-windows/phantomjs.exe";
    public DriverFactory(){}

    public WebDriver getDriver(){
        DesiredCapabilities capabilities = DesiredCapabilities.phantomjs(); // or new DesiredCapabilities();
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
                new String[] {"--ssl-protocol=tlsv1","--web-security=false"});

        capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                path);


        return new PhantomJSDriver(capabilities);
    }
}
