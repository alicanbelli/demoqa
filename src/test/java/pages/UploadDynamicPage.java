package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class UploadDynamicPage {
    public UploadDynamicPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "item-6")
    public WebElement uploadAndDownload;
    @FindBy(id = "downloadButton")
    public WebElement downloadButton;
    @FindBy(id = "item-7")
    public WebElement dynamicProperties;
    @FindBy(xpath = "//*[.='This text has random Id']")
    public WebElement dynamicText;
    @FindBy


}
