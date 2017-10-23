import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestHelper {

    public String title (WebDriver driver){
        return driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
    }
}
