package mobile_tests;

import config.AppData;
import config.MobileData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Utils {
    static AndroidDriver<MobileElement> driver;
    MobileData mobileData = new MobileData();
    String mobileUuid = mobileData.Mobile_UUID;
    String mobileDeviceName = mobileData.Mobile_DeviceName;
    String mobilePlatformName = mobileData.Mobile_PlatformName;
    String mobilePlatformVersion = mobileData.Mobile_PlatformVersion;
    AppData appData = new AppData();
    String appPackage = appData.AppPackage;
    String appActivity = appData.AppActivity;
    String baseUrl = appData.Url;

    public void setup() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.UDID, mobileUuid);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, mobileDeviceName);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, mobilePlatformName);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, mobilePlatformVersion);
        cap.setCapability("appPackage", appPackage);
        cap.setCapability("appActivity", appActivity);

        URL url = null;
        try {
            url = new URL(baseUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<MobileElement>(url, cap);
        System.out.println("Application started.........");
    }

    public void QuitDriver(){
        driver.quit();
    }

    public MobileElement GetElementById(String id) throws Exception {
        try {
            MobileElement element = driver.findElement(By.id(id));
            return element;
        } catch (Exception exp) {
            exp.getCause();
            exp.getMessage();
        }
        return null;
    }

    public MobileElement GetElementByXpath(String xpath) throws Exception {
        try {
            MobileElement element = driver.findElement(By.xpath(xpath));
            return element;
        } catch (Exception exp) {
            exp.getCause();
            exp.getMessage();
        }
        return null;
    }

    public MobileElement WaitGetElementById(String id) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            boolean ElementIsVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
            if (Boolean.TRUE.equals(ElementIsVisible)) {
                System.out.println("element is visible");
                MobileElement element = driver.findElement(By.id(id));
                return element;
            }
        } catch (Exception exp) {
            exp.getCause();
            exp.getMessage();
        }
        return null;
    }
}
