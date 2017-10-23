import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private final WebDriver driver;

    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void authorization (String log, String pas){
        driver.findElement(By.id("id_username")).sendKeys(log);
        driver.findElement(By.id("id_password")).sendKeys(pas);
        driver.findElement(By.className("submit-row")).click();
    }


}
