package academy;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver; //Created driver instance only once by defining it as a  global variable
    public Properties prop;
    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
         FileInputStream fis = new FileInputStream("E:\\Automation\\spicejet-search-framework\\src\\main\\java\\academy\\data.properties");
         //gets error in FileInputStream hence added FileNotFoundException in the method signature
        prop.load(fis); //get error in load hence added IOException, pass fis object which has the knowledge on properties file
        String browserName=prop.getProperty("browser"); //extracted value from properties file
        if(browserName.equals("chrome")) {
            System. setProperty("webdriver.chrome.driver", "E:\\driver\\chromedriver_win32\\chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver","E:\\Driver\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else {
            System.setProperty("webdriver.ie.driver","E:\\Driver\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        //End of loop
        //set timeout here so that this applies to all the testcases
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //return the driver object to back
        return driver;
     //End of method
    }
    //Method to take screenshots
    public void getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\reports\\"+testcaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
    }
    //End of Class
}
