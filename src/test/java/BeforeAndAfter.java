import api.constants.Browser;
import api.user.UserGenerator;
import api.user.UserRegistration;
import api.user.UserRequests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BeforeAndAfter {
    WebDriver driver;
    String accessToken;
    UserRequests userRequests;
    UserRegistration userRegistration;

    @Before
    public void setUp() {
        driver = Browser.getDriver();
        userRegistration = UserGenerator.getUserRandom();
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            userRequests.deleteUser(accessToken);
        }
        driver.quit();
    }
}
