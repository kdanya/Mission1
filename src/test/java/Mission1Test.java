import org.junit.Assert;
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
        LoginPage login = new LoginPage(driver);
        login.authorization("silenium","super_password");

        // 5) Verifies that a new page has a header - "Панель управления"
        AdminPage tHelp = new AdminPage(driver);
        Assert.assertEquals(tHelp.getTitle(),"Панель управления");

        // 6)Click button addEntries
        tHelp.clickAddEntries();

        // 7) Verifies that a new page has a header - "Добавить entry"
        Assert.assertEquals(tHelp.getTitle(),"Добавить entry");

        // 8-11) Write lines: title, slug, text markdown, text
        String titleLine = "TITLE_1234321";
        tHelp.fillEntry(titleLine,"SLUG_1234321","TEXT_MAR_1234321","TEXT_1234321");

        // 12) Click button save
        tHelp.clickSaveButton();

        // 13) Open page http://igorakintev.ru/blog/
        driver.get("http://igorakintev.ru/blog/");

        // 14) Verifies that a new page has a section
        Assert.assertEquals(tHelp.searchSection(titleLine),titleLine);

        // 15) Delete
        driver.get("http://igorakintev.ru/admin/blog/entry/");
        tHelp.deleteSection(titleLine);

    }

}
