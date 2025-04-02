package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BaseClass {

    private WebDriver driver;

    private By menuButton=By.id("react-burger-menu-btn");

    private By logOutLink=By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickMenuButton(){
        driver.findElement(menuButton).click();
    }

    public void clickLogOutLink(){
        driver.findElement(logOutLink).click();
    }

    public boolean isAtProductsPage(){
        return driver.getCurrentUrl().contains("inventory.html");
    }


}
