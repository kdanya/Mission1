import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestHelper {

    public String title (WebDriver driver){
        return driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
    }

    public void clickAddEntries(WebDriver driver){
        driver.findElement(By.xpath("//a[@class='addlink' and @href='/admin/blog/entry/add/']")).click();
    }

    public void writeLines(WebDriver driver,String title,String slug,String textMar,String text){
        driver.findElement(By.id("id_title")).sendKeys(title);
        driver.findElement(By.id("id_slug")).clear();
        driver.findElement(By.id("id_slug")).sendKeys(slug);
        driver.findElement(By.id("id_text_markdown")).sendKeys(textMar);
        driver.findElement(By.id("id_text")).sendKeys(text);
    }

    public void saveButton (WebDriver driver){
        driver.findElement(By.className("submit-row")).findElement(By.className("default")).submit();
    }

    public String searchSection(WebDriver driver, String title){
       return driver.findElement(By. id("entries")).findElement(By.linkText(title)).getText();
    }


}
