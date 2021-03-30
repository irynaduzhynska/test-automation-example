package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;
    /*
    Поле ввода текста для поиска
     */
    @FindBy(id = "q")
    WebElement searchInputField;
    /*
    Кнопка 'Search'
     */
    @FindBy(css = "input[type='submit']")
    WebElement searchBatton;

    public MainPage(WebDriver driver) {
        this.webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }


    public void searchFor(String text){
        searchInputField.clear();
        searchInputField.sendKeys(text);
//        searchInputField.submit();
    }
    public void clickSearchBatton(){
        searchBatton.click();
    }
}
