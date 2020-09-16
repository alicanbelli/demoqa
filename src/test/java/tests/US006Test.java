package tests;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DemogaWebTablesButtonsLinksPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


import java.util.Iterator;
import java.util.Set;

public class US006Test {
    DemogaWebTablesButtonsLinksPage demogaWebTablesButtonsLinksPage = new DemogaWebTablesButtonsLinksPage();
    @BeforeTest
    public void stars(){
        Driver.getDriver().get(ConfigReader.getProperty("demoqa"));
    }
    @Test
    public void tc025(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.links.click();
        Assert.assertEquals(demogaWebTablesButtonsLinksPage.pagePageHeader.getText(),"Links");
        String colorValue = demogaWebTablesButtonsLinksPage.pagePageHeader.getCssValue("color");
        String colorHex = Color.fromString(colorValue).asHex();
        System.out.println(colorHex);
        Assert.assertEquals(colorHex,"#aaaaaa");
        }
    @Test
    public void tc026(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.links.click();
        demogaWebTablesButtonsLinksPage.simpleLink.click();
        ReusableMethods.waitFor(2);
        String parentWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        Iterator var4 = allWindowHandles.iterator();
        String childWindowHandle;
        while (var4.hasNext()){
            childWindowHandle = (String)var4.next();
            if(!childWindowHandle.equals(parentWindowHandle)){
                Driver.getDriver().switchTo().window(childWindowHandle);
            }
        }
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://demoqa.com/");
    }
    @Test
    public void tc27(){
        demogaWebTablesButtonsLinksPage.elementsCard.click();
        demogaWebTablesButtonsLinksPage.links.click();
        demogaWebTablesButtonsLinksPage.modevLink.click();
        Assert.assertEquals(demogaWebTablesButtonsLinksPage.statusCode.getText(),"301");
    }

}
