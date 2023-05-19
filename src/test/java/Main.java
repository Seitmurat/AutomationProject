import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.cert.ocsp.Req;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;



public class Main {
    WebDriver driver;

    String acc_id;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test()
    public void RegisterAndLogin() {
        RegisterAndLogin RegAndLog = new RegisterAndLogin(driver);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        RegAndLog.reg_btn();
        RegAndLog.f_name("Seitmurat");
        RegAndLog.l_name("Seitkul");
        RegAndLog.c_address("Manasa 59a");
        RegAndLog.c_city("Almaty");
        RegAndLog.c_state("UKO");
        RegAndLog.c_zipcode("160001");
        RegAndLog.c_phone("87474519384");
        RegAndLog.c_ssn("abc");
        RegAndLog.c_username("SeitmuratS");
        RegAndLog.c_password("Sikow.2020");
        RegAndLog.c_repassword("Sikow.2020");
        RegAndLog.RegBtnClick();
        Assert.assertEquals(RegAndLog.confirmation(), "Your account was created successfully. You are now logged in.");
    }
    @Test(priority = 1)
    public void OpenNewAccount() throws InterruptedException {
       OpenNewAccount OpenNewAcc = new OpenNewAccount(driver);
       OpenNewAcc.OpenNew();
        Thread.sleep(2000);
       OpenNewAcc.Register();
       Thread.sleep(2000);
       Assert.assertEquals(OpenNewAcc.confirmation(), "Account Opened!");
    }
    @Test(priority = 2)
    public void TransferFunds() throws InterruptedException {
        TransferFunds TransferMoney= new TransferFunds(driver);
        TransferMoney.TransferBtn();
        Thread.sleep(1000);
        TransferMoney.Money("10");
        TransferMoney.Transfer();
        Thread.sleep(2000);
        Assert.assertEquals(TransferMoney.TransferConfirm(), "Transfer Complete!");
    }
    @Test(priority = 3)
    public void BillPayment() throws InterruptedException {
        BillPayment BillPay = new BillPayment(driver);
        BillPay.AccOverview();
        acc_id = BillPay.AccId();
        Thread.sleep(2000);
        BillPay.BillPayButton();
        BillPay.Payee_name("Seitmurat");
        BillPay.Payee_addr("Manasa 59a");
        BillPay.Payee_city("Almaty");
        BillPay.Payee_state("UKO");
        BillPay.Payee_zipCode("160001");
        BillPay.Payee_phoneNumber("87474519384");
        BillPay.accountNumber(acc_id);
        BillPay.VerifyAcc(acc_id);
        BillPay.Payee_amount("100");
        BillPay.SendBtn();
        Assert.assertEquals(BillPay.PaymentConfirm(), "Bill Payment Complete");
    }
    @Test(priority = 4)
    public void FindTransaction(){
        FindTransaction FindTran = new FindTransaction(driver);
        FindTran.FindTransactionBtn();
        FindTran.Criteria("100");
        FindTran.FindButton();
        Assert.assertEquals(FindTran.TransactionResult(), "Funds Transfer Sent");
        FindTran.Details();
        Assert.assertEquals(FindTran.DetailsConfirmation(), "Transaction Details");
    }
    @Test(priority = 5)
    public void UpdateInfo() throws InterruptedException {
        UpdateInfo Update = new UpdateInfo(driver);
        Update.UpdateContactBtn();
        Thread.sleep(2000);
        Update.Customer_City();
        Update.Customer_city("Shymkent");
        Update.Update_btn();
        Thread.sleep(2000);
        Assert.assertEquals(Update.UpdateConfirm(), "Profile Updated");
    }
    @Test(priority = 6)
    public void RequestLoan() throws InterruptedException {
        RequestLoan Request = new RequestLoan(driver);
        Request.RequestBtn();
        Request.Loan_amount("100");
        Request.Down_payment("100");
        Request.Apply();
        Thread.sleep(2000);
        Assert.assertEquals(Request.Confirm(), "Wealth Securities Dynamic Loans (WSDL)");
    }
}

