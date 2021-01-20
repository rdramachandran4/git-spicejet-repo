import academy.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchresultPage;

import java.io.IOException;

public class SearchTest extends Base {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver(); //got an error hence added IOException
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void getSpicegetPage() {
        SearchPage searchpage = new SearchPage(driver);
        searchpage.getPickupLocation().click();
        searchpage.selectPickupLocation().click();
        searchpage.getDropoffLocation().click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        searchpage.clickSearchBtn().click();
        SearchresultPage result = new SearchresultPage(driver);
        result.waitforElement(20);
        Assert.assertTrue(result.modifySearch().isDisplayed(),"Search result page is loaded successfully");
    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
