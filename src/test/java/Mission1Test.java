import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mission1Test {
    private static WebDriver driver;

    @BeforeClass
    public static void openBrowser(){
        String pathToChromeDriver = System.getProperty("user.dir") + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        driver = new ChromeDriver();
    }

    @Test
    public void main() {
        // 1) Comes to the page http://igorakintev.ru/admin/
        driver.get("http://igorakintev.ru/admin/");

        // 2-4) Authorization
        LoginPage login = new LoginPage();
        login.authorization(driver,"silenium","super_password");

    }

}
