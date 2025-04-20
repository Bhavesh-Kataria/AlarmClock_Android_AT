import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AlarmClockTest {
    public static AndroidDriver driver;
    public static DesiredCapabilities dcs;

    @BeforeClass
    public void setUp(){
        dcs = new DesiredCapabilities();
        dcs.setCapability("deviceName", "127.0.0.1:6555");
        dcs.setCapability("platformName", "Android");
        dcs.setCapability("platformVersion", "9.0");
        dcs.setCapability("appPackage","com.android.deskclock");
        dcs.setCapability("appActivity","com.android.deskclock.DeskClock");
        dcs.setCapability("adbExecTimeout", 30000); // Increase timeout to 30 seconds (default is 20s)
        dcs.setCapability("newCommandTimeout", 600);  // Increase timeout for commands

        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dcs);
        } catch (MalformedURLException mue) {
            mue.getStackTrace();
        }
    }


    public void startStopWatch(){
        driver.findElement(AppiumBy.accessibilityId("Stopwatch")).click();
        driver.findElement(AppiumBy.accessibilityId("Start")).click();
    }

    @Test
    public void setAlarm() throws InterruptedException {
        startStopWatch();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Alarm")).click();
        driver.findElement(AppiumBy.accessibilityId("Add alarm")).click();
        driver.findElement(AppiumBy.accessibilityId("4")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(By.id("android:id/pm_label")).click();
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(3000);
//        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("com.android.deskclock:id/repeat_onoff")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Sunday")).click();
        driver.findElement(AppiumBy.accessibilityId("Monday")).click();
        driver.findElement(AppiumBy.accessibilityId("Tuesday")).click();
        driver.findElement(AppiumBy.accessibilityId("Thursday")).click();
        driver.findElement(AppiumBy.accessibilityId("Friday")).click();
        driver.findElement(AppiumBy.accessibilityId("Saturday")).click();
        driver.findElement(By.id("com.android.deskclock:id/edit_label")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.EditText")).sendKeys("Manual Testing Review");
        Thread.sleep(3000);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Collapse alarm']")).click();
        pauseStopWatch();
    }

    public void pauseStopWatch(){
        driver.findElement(AppiumBy.accessibilityId("Stopwatch")).click();
        driver.findElement(AppiumBy.accessibilityId("Pause")).click();
//        String timeTaken = driver.findElement(By.id("com.android.deskclock:id/stopwatch_time_text")).getText();
//        System.out.println(timeTaken);
    }
}
