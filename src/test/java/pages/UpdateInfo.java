package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UpdateInfo{
    WebDriver driver;

    @FindBy(linkText = "Update Contact Info")
    WebElement UpdateContact;
    @FindBy(id = "customer.address.city")
    WebElement customer_city;
    @FindBy(xpath = "//*[@id='rightPanel']/div/div/form/table/tbody/tr[8]/td[2]/input")
    WebElement UpdateBtn;
    @FindBy(tagName = "h1")
    WebElement ProfileUpdate;

    public UpdateInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void UpdateContactBtn(){
        UpdateContact.click();
    }
    public void Customer_City(){
        customer_city.clear();
    }
    public void Customer_city(String city){
        customer_city.sendKeys(city);
    }
    public void Update_btn(){
        UpdateBtn.click();
    }
    public String UpdateConfirm(){
        return ProfileUpdate.getText();
    }
}
