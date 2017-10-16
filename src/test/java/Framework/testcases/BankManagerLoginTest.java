package Framework.testcases;

import Framework.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by s.milaserdov on 10/6/2017.
 */
public class BankManagerLoginTest extends BaseTest {

    @Test
    public void BankManagerLoginTest() throws InterruptedException{

        driver.findElement(By.xpath(OR.getProperty("BMLBtn"))).click();
        //Thread.sleep(5);

        Assert.assertTrue(isElementPresent(OR.getProperty("Adding_customer")));


    }
}
