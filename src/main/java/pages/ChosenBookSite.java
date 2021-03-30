package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ChosenBookSite {
    WebDriver webDriver;


    public ChosenBookSite(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriver.get("https://itbook.store/books/9781849689465");
    }
}
