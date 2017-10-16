package Framework.testcases;

import Framework.base.BaseTest;
import Framework.listeners.TestUtil;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by s.milaserdov on 10/11/2017.
 */
public class AddCustomerTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void addCustomer(String fName, String lName, String postcode){

        driver.findElement(By.cssSelector(OR.getProperty("Adding_customer"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("fname"))).sendKeys(fName);
        driver.findElement(By.cssSelector(OR.getProperty("lname"))).sendKeys(lName);
        driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postcode);
        driver.findElement(By.cssSelector(OR.getProperty("addCustomerButton"))).click();

    }

    @DataProvider
    public static Object[][]getData(){

       return TestUtil.getData("AddCustomerTest");


    }
}
