package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class loginSteps extends BaseClass {

    WebDriver driver;

//    @Given("User navigates to login page")
//    public void user_navigates_to_login_page() {
//
//        System.out.println("Inside step - User navigates to login page");
//
//        driver=getDriver();
//
//        driver.get(properties.getProperty("url"));
//
//        loginPage=new LoginPage(driver);
//
//    }
//    @When("User enters valid credentials")
//    public void user_enters_valid_credentials() {
//
//        System.out.println("Inside step - User enters valid credentials");
//
//        loginPage.enterUsername("standard_user");
//        loginPage.enterPassword("secret_sauce");
//
//    }
//    @When("Click on login button")
//    public void click_on_login_button() {
//
//        System.out.println("Inside step - Click on login button");
//
//        loginPage.clickLogin();
//
//    }
//    @Then("User should see the dashboard")
//    public void user_should_see_the_dashboard() {
//
//        System.out.println("Inside step - User should see the dashboard");
//
//    }

    @Given("the user in on the loginPage")
    public void the_user_in_on_the_login_page() {
        System.out.println("Inside step - User navigates to login page");

        driver=getDriver();

        driver.get(properties.getProperty("url"));

        loginPage=new LoginPage(driver);
    }
    @When("the user enters username {string}")
    public void the_user_enters_username(String username) {
        System.out.println("Inside step - User enters valid username");

        loginPage.enterUsername(username);

    }
    @When("the user enters password {string}")
    public void the_user_enters_password(String password) {
        System.out.println("Inside step - User enters valid password");

        loginPage.enterPassword(password);
    }
    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        System.out.println("Inside step - Click on login button");

        loginPage.clickLogin();

    }
    @Then("the use should be redirected to the product page")
    public void the_use_should_be_redirected_to_the_product_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,loginPage.getErrorMessage());
    }

    @When("the user leaves both username and password fields empty")
    public void the_user_leaves_both_username_and_password_fields_empty() {
        loginPage.enterUsername("");  // Passing empty string to simulate empty input
        loginPage.enterPassword("");  // Same for password
    }

    @Then("the user should be redirected to the products page")
    public void the_user_should_be_redirected_to_the_products_page() {
        productsPage=new ProductsPage(driver);
        Assert.assertTrue("Login failed! User is not on the Products Page.",productsPage.isAtProductsPage());

    }
    @When("the user clicks the menu button")
    public void the_user_clicks_the_menu_button() {
        productsPage.clickMenuButton();
    }
    @When("the user clicks the logout option")
    public void the_user_clicks_the_logout_option() {
        productsPage.clickLogOutLink();
    }
    @Then("the user should be redirected back to the login page")
    public void the_user_should_be_redirected_back_to_the_login_page() {
        Assert.assertTrue("Logout failed! User is not back on the Login Page.",driver.getPageSource().contains("Login"));
    }


}
