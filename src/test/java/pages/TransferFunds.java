package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TransferFunds {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='leftPanel']/ul/li[3]/a")
    WebElement TransferLink;
    @FindBy(id = "amount")
    WebElement CashAmount;
    @FindBy(xpath = "//*[@id='rightPanel']/div/div/form/div[2]/input")
    WebElement Transfer;

    @FindBy(xpath = "//*[@id='rightPanel']/div/div/h1")
    WebElement TransferConfirmation;

    public TransferFunds(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void TransferBtn(){
        TransferLink.click();
    }
    public void Money(String cash){
        CashAmount.sendKeys(cash);
    }
    public void Transfer(){
        Transfer.click();
    }
    public String TransferConfirm(){
        return TransferConfirmation.getText();
    }
}
