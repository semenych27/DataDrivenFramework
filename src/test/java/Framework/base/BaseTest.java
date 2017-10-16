package Framework.base;

import Framework.commonutilities.ExcelReader;
import Framework.commonutilities.DbManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by s.milaserdov on 10/5/2017.
 */

//WebDriver, email, logs, dbconnection
public class BaseTest {

    public static WebDriver driver;
    public static Properties OR = new Properties();
    public  static Properties Config = new Properties();
    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\java\\Framework\\testdata\\testdata.xlsx");
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    @BeforeSuite
    public void setUp(){

        if(driver == null){

            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Framework\\properties\\CONFIG.properties");
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }

            try {
                Config.load(fis);
                log.info("Config properties file loaded");
            }catch(IOException e){
                e.printStackTrace();
            }

            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Framework\\properties\\OR.properties");
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }

            try {
                OR.load(fis);
                log.info("OR properties file loaded");
            }catch(IOException e){
                e.printStackTrace();
            }

            if(Config.getProperty("browser").equals("firefox")){
                driver = new FirefoxDriver();
                log.info("Firefox is launched");
            } else if(Config.getProperty("browser").equals("chrome")){
                driver = new ChromeDriver();
                log.info("Chrome is launched");
            }

            driver.get(Config.getProperty("testsiteurl"));
            log.info("Navigated to " + Config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            /*try {
                DbManager.setMysqlDbConnection();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            } */

            
        }

    }

    public static boolean isElementPresent(String locator){

           int size = driver.findElements(By.cssSelector(locator)).size();

           if(size ==0){
               return false;
           }else{
               return true;
           }

    }
    
    @AfterSuite
    public void tearDown(){
          driver.quit();
    }
}
