package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillPayment {
    WebDriver driver;

    @FindBy(xpath = "//*[@id='leftPanel']/ul/li[2]/a")
    WebElement AccountOverview;
    @FindBy(xpath = "//*[@id='accountTable']/tbody/tr[1]/td[1]/a")
    WebElement AccountID;

    @FindBy(xpath = "//*[@id='leftPanel']/ul/li[4]/a")
    WebElement BillPayBtn;
    @FindBy(name = "payee.name")
    WebElement payee_name;
    @FindBy(name = "payee.address.street")
    WebElement payee_address;
    @FindBy(name = "payee.address.city")
    WebElement payee_city;
    @FindBy(name = "payee.address.state")
    WebElement payee_state;
    @FindBy(name = "payee.address.zipCode")
    WebElement payee_zipCode;
    @FindBy(name = "payee.accountNumber")
    WebElement payee_accountNumber;
    @FindBy(name = "verifyAccount")
    WebElement verifyAccount;
    @FindBy(name = "amount")
    WebElement amount;
    @FindBy(name = "payee.phoneNumber")
    WebElement payee_phoneNumber;

    @FindBy(xpath = "//*[@id='rightPanel']/div/div[1]/form/table/tbody/tr[14]/td[2]/input")
    WebElement SendPayment;
    @FindBy(xpath = "//*[@id='rightPanel']/div/div[2]/h1")
    WebElement PaymentConfirmation;

    public BillPayment(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void AccOverview(){
        AccountOverview.click();
    }
    public String AccId(){
       return AccountID.getText();
    }
    public void BillPayButton(){
        BillPayBtn.click();
    }
    public void Payee_name(String name){
        payee_name.sendKeys(name);
    }
    public void Payee_addr(String addr){
        payee_address.sendKeys(addr);
    }
    public void Payee_city(String city){
        payee_city.sendKeys(city);
    }
    public void Payee_state(String state){
        payee_state.sendKeys(state);
    }
    public void Payee_zipCode(String zipCode){
        payee_zipCode.sendKeys(zipCode);
    }
    public void Payee_phoneNumber(String phoneNum){
        payee_phoneNumber.sendKeys(phoneNum);
    }
    public void accountNumber(String accNumber){
        payee_accountNumber.sendKeys(accNumber);
    }
    public void VerifyAcc(String verifyAcc){
        verifyAccount.sendKeys(verifyAcc);
    }
    public void Payee_amount(String Amount){
        amount.sendKeys(Amount);
    }
    public void SendBtn(){
        SendPayment.click();
    }
    public String PaymentConfirm(){
        return PaymentConfirmation.getText();
    }
}
