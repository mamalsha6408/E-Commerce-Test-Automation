package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

    @Before
    public void setup(){
        System.out.println("Initializing WebDriver...");
        initializeDriver();

    }

    @After
    public void teardown(){
        System.out.println("Closing browser...");
        if(driver!=null){
            driver.quit();
        }
    }

}
