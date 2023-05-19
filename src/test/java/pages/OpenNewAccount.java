package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccount {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='leftPanel']/ul/li[1]/a")
    WebElement NewAccountBtn;
    @FindBy(xpath = "//*[@id='rightPanel']/div/div/form/div/input")
    WebElement RegNewAcc;

    @FindBy(xpath = "//*[@id='rightPanel']/div/div/h1")
    WebElement confirm;

    public OpenNewAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void OpenNew(){
        NewAccountBtn.click();
    }
    public void Register(){
        RegNewAcc.click();
    }
    public String confirmation(){
        return confirm.getText();
    }
}
