import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners (ITestListener.class)

public class OrangeHRM {

    public static WebDriver driver;
    static  String BaseURL = "https://opensource-demo.orangehrmlive.com/";
    static JavascriptExecutor js;

    @BeforeTest
    public  static void WebSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "G:\\Programming\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get((BaseURL));
        //Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));


    }

    @Test(priority = 0)
    public static void OrangeHRMLogin() throws Exception {

        MyScreenRecorder.startRecording("");


        driver.findElement(By.xpath("//input[@id='txtUsername']")).click();
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).click();
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"));

        MyScreenRecorder.stopRecording();

    }

    @Test(priority = 1)
    public static void Dashboard() throws Exception {
        MyScreenRecorder.startRecording("");

        //driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]")).click();
        driver.findElement(By.xpath("//b[contains(text(),'Dashboaghjghjgh]")).click();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)", "");
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(450,0)", "");
        Thread.sleep(3000);

        MyScreenRecorder.stopRecording();

    }

    @Test(priority = 2)
    public static void ApplyLeave() throws Exception {
        //MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 3)
    public static void MyLeave() throws Exception {
        //MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'My Leave')]")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 4)
    public static void MyTimesheet() throws Exception {
        //MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(),'My Timesheet')]")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 5)
    public static void PIM() throws Exception {
        //MyScreenRecorder.startRecording("");
        driver.findElement(By.xpath("//b[contains(text(),'Dashboard')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 6)
    public static void EmployeeName() throws Exception {
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("Alexa");
        Thread.sleep(1000);
    }

    @Test(priority = 7)
    public static void ID() throws Exception {
        driver.findElement(By.xpath("//input[@id='empsearch_id']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_id']")).sendKeys("1234");
        Thread.sleep(1000);
    }

    @Test(priority = 8)
    public static void EmploymentStatus() throws Exception {
        driver.findElement(By.xpath("//select[@id='empsearch_employee_status']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 9)
    public static void Include() throws Exception {
        driver.findElement(By.xpath("//select[@id='empsearch_termination']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 10)
    public static void SupervisorName() throws Exception {
        driver.findElement(By.xpath("//input[@id='empsearch_supervisor_name']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_supervisor_name']")).sendKeys("Josh");
        Thread.sleep(1000);
    }

    @Test(priority = 11)
    public static void JobTitle() throws Exception {
        driver.findElement(By.xpath("//select[@id='empsearch_job_title']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 12)
    public static void SubUnit() throws Exception {
        driver.findElement(By.xpath("//select[@id='empsearch_sub_unit']")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 13)
    public static void Search() throws Exception {
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(1000);
    }


    @AfterTest
    public static void TestClosure(){

        driver.quit();

    }

}
