package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    public WebDriver driver;

    By pickupLocation = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By selectPickup   = By.xpath("//a[@value='MAA']");
    By dropOffLocation = By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']");
    By searchBtn       = By.name("ctl00$mainContent$btn_FindFlights");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getPickupLocation() {
        return driver.findElement(pickupLocation);
    }
    public WebElement getDropoffLocation() {
        return driver.findElement(dropOffLocation);
    }
    public WebElement clickSearchBtn() {
        return driver.findElement(searchBtn);
    }
    public WebElement selectPickupLocation() {
        return driver.findElement(selectPickup);
    }
}
