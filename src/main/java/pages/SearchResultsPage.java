package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }
    public void waitForSearchResults(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("gsc-webResult")));
    }
    public ChosenBookSite openBookFromResultPageBy(){
        webDriver.findElement(By.xpath("//div[@class='gsc-expansionArea']/div[1]//div[@class='gs-title']")).click();
        return new ChosenBookSite(webDriver);
    }
}
