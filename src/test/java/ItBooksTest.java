import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BooksSite;
import pages.MainPage;


public class ItBooksTest {
    BooksSite booksSite;
    WebDriver webDriver;
    WebDriverWait wait;


    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver","D:/List_of_Jar/chromedriver.exe");
        webDriver = new ChromeDriver();
        booksSite = new BooksSite(webDriver);
    }

    @AfterMethod
    public void tearDown(){
        if(webDriver!=null) {
            webDriver.quit();
        }
    }

    @Test
    public void testEbookUrl(){
        webDriver.get("https://it-ebooks.info/");
//        webDriver.findElement(By.id("q")).clear();
//        webDriver.findElement(By.id("q")).sendKeys("Automation");
//        webDriver.findElement(By.cssSelector("input[type='submit']")).click();
        booksSite.mainPage().searchFor("Automation");
        booksSite.mainPage().clickSearchBatton();
        System.out.println(webDriver.getCurrentUrl());
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://it-ebooks-search.info/search?q=Automation");
    }

    @Test
    public void testBookSearch() throws Exception {
        wait = new WebDriverWait(webDriver, 20, 1000);
        webDriver.get("https://it-ebooks.info/");
//        webDriver.findElement(By.cssSelector(""))
        webDriver.findElement(By.id("q")).clear();
        webDriver.findElement(By.id("q")).sendKeys("Automation");
        webDriver.findElement(By.id("q")).submit(); // або можна ще так ---> webDriver
        // .findElement(By.cssSelector("input[type='submit']")).click();

       booksSite.searchResultsPage().waitForSearchResults();
        Assert.assertTrue(webDriver.findElements(By
                .className("gsc-webResult")).size()>0);
    }

    @Test
    public void choosingBookOnResultPage(){
        webDriver.get("https://it-ebooks.info/");
        booksSite.mainPage().searchFor("Automation");
        booksSite.mainPage().clickSearchBatton();
        booksSite.searchResultsPage()
                .openBookFromResultPageBy();
//        booksSite.searchResultsPage().waitForSearchResults();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://itbook.store/books/9781849689465");
    }
}
