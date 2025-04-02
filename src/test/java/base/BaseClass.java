package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        //for github
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--no-sandbox"); // Required for GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Avoid shared memory issues
        options.addArguments("--disable-gpu"); // Disable GPU rendering
        options.addArguments("--remote-allow-origins=*"); // Avoid CORS issues

        driver=new ChromeDriver(options);
        //for github

        //local run
        //driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver(){
        return driver;
    }


}
