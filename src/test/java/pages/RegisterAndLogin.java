package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAndLogin {

    WebDriver driver;
    @FindBy(xpath = "//*[@id='loginPanel']/p[2]/a")
    WebElement regbtn;
    @FindBy(id = "customer.firstName")
    WebElement fname;
    @FindBy(id = "customer.lastName")
    WebElement lname;
    @FindBy(id = "customer.address.street")
    WebElement addr;
    @FindBy(id = "customer.address.city")
    WebElement city;
    @FindBy(id = "customer.address.state")
    WebElement state;
    @FindBy(id = "customer.address.zipCode")
    WebElement zipCode;
    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumber;
    @FindBy(id = "customer.ssn")
    WebElement ssn;
    @FindBy(id = "customer.username")
    WebElement username;
    @FindBy(id = "customer.password")
    WebElement password;
    @FindBy(id = "repeatedPassword")
    WebElement repassword;
    @FindBy(xpath = "//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")
    WebElement register;
    @FindBy(xpath = "//*[@id='rightPanel']/p")
    WebElement confirm;
    public RegisterAndLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void reg_btn(){
        regbtn.click();
    }
    public void f_name(String first_name){
        fname.sendKeys(first_name);
    }
    public void l_name(String last_name){
        lname.sendKeys(last_name);
    }
    public void c_address(String Address){
        addr.sendKeys(Address);
    }
    public void c_city(String City){
        city.sendKeys(City);
    }
    public void c_state(String State){
        state.sendKeys(State);
    }
    public void c_zipcode(String ZipCode){
        zipCode.sendKeys(ZipCode);
    }
    public void c_phone(String PhoneNumber){
        phoneNumber.sendKeys(PhoneNumber);
    }
    public void c_ssn(String Ssn){
        ssn.sendKeys(Ssn);
    }
    public void c_username(String Username){
        username.sendKeys(Username);
    }
    public void c_password(String Password){
        password.sendKeys(Password);
    }
    public void c_repassword(String RePassword){
        repassword.sendKeys(RePassword);
    }
    public void RegBtnClick(){
        register.click();
    }
    public String confirmation(){
        return confirm.getText();
    }

}
