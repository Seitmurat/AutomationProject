package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FindTransaction {
    WebDriver driver;

    @FindBy(linkText = "Find Transactions")
    WebElement FindTransaction;
    @FindBy(id = "criteria.amount")
    WebElement criteria;
    @FindBy(xpath = "//*[@id='rightPanel']/div/div/form/div[9]/button")
    WebElement FindBtn;

    @FindBy(linkText = "Funds Transfer Sent")
    WebElement Result;

    @FindBy(className = "title")
    WebElement details;

    public FindTransaction(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void FindTransactionBtn(){
        FindTransaction.click();
    }
    public void Criteria(String cash){
        criteria.sendKeys(cash);
    }
    public void FindButton(){
        FindBtn.click();
    }
    public String TransactionResult(){
        return Result.getText();
    }
    public void Details(){
        Result.click();
    }
    public String DetailsConfirmation(){
        return details.getText();
    }
}
