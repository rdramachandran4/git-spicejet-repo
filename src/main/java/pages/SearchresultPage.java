package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchresultPage {
    public WebDriver driver;

    By modifySearchLink = By.xpath("//div[@class='trip-modify']");
    public SearchresultPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement modifySearch() {
        return driver.findElement(modifySearchLink);
    }
    public void waitforElement(int sec) {
        WebDriverWait wait = new WebDriverWait(driver,sec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(modifySearchLink));
    }
}
