import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    private final WebDriver driver;

    public  AdminPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle (){
        return driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
    }

    public void clickAddEntries(){
        driver.findElement(By.xpath("//a[@class='addlink' and @href='/admin/blog/entry/add/']")).click();
    }

    public void fillEntry(String title,String slug,String textMar,String text){
        driver.findElement(By.id("id_title")).sendKeys(title);
        driver.findElement(By.id("id_slug")).clear();
        driver.findElement(By.id("id_slug")).sendKeys(slug);
        driver.findElement(By.id("id_text_markdown")).sendKeys(textMar);
        driver.findElement(By.id("id_text")).sendKeys(text);
    }

    public void clickSaveButton (){
        driver.findElement(By.className("submit-row")).findElement(By.className("default")).submit();
    }

    public String searchSection(String title){
        return driver.findElement(By. id("entries")).findElement(By.linkText(title)).getText();
    }

    public void deleteSection(String title){
        String delUrl = driver.findElement(By.linkText(title)).getAttribute("href")+"delete/";
        driver.findElement(By.linkText(title)).click();
        driver.get(delUrl);
        driver.findElement(By.xpath("//*[@id=\'content\']/form/div/input[2]")).submit();
    }
}
