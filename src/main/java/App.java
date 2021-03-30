import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BooksSite;

public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:/List_of_jar/chromedriver.exe");
        WebDriver webDriver  = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        BooksSite booksSite = new BooksSite(webDriver);
        try {
            webDriver.get("https://it-ebooks.info/");
            System.out.println(webDriver.getCurrentUrl());
            booksSite.mainPage().searchFor("Automation");
            booksSite.mainPage().clickSearchBatton();
            booksSite.searchResultsPage().waitForSearchResults();
            booksSite.searchResultsPage().openBookFromResultPageBy();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/*")));
            System.out.println(webDriver.getCurrentUrl());

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            webDriver.quit();
        }
    }
}
