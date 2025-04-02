package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    protected static WebDriver driver;

    protected static Properties properties;

    protected LoginPage loginPage;

    protected ProductsPage productsPage;

    //Load config properties
    public BaseClass(){

        try {

            properties=new Properties();
            FileInputStream file=new FileInputStream("src/test/resources/config/config.properties");
            properties.load(file);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initializeDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver(){
        return driver;
    }


}
