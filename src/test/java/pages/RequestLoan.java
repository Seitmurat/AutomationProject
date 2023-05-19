package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RequestLoan{
    WebDriver driver;

    @FindBy(linkText = "Request Loan")
    WebElement RequestLoan;
    @FindBy(id = "amount")
    WebElement loan_amount;
    @FindBy(id = "downPayment")
    WebElement down_payment;
    @FindBy(xpath = "//*[@id='rightPanel']/div/div/form/table/tbody/tr[4]/td[2]/input")
    WebElement ApplyBtn;
    @FindBy(id = "loanProviderName")
    WebElement LoanConfirm;

    public RequestLoan(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void RequestBtn(){
        RequestLoan.click();
    }
    public void Loan_amount(String cash){
        loan_amount.sendKeys(cash);
    }
    public void Down_payment(String cash){
        down_payment.sendKeys(cash);
    }
    public void Apply(){
        ApplyBtn.click();
    }
    public String Confirm(){
        return LoanConfirm.getText();
    }
}
