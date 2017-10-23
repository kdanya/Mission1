import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

   //private WebDriver driver;


    public void authorization (WebDriver driver, String log, String pas){
        driver.findElement(By.id("id_username")).sendKeys(log);
        driver.findElement(By.id("id_password")).sendKeys(pas);
        driver.findElement(By.className("submit-row")).click();
    }


}
