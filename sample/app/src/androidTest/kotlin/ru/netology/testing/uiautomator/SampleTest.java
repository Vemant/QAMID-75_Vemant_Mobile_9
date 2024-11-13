package ru.netology.testing.uiautomator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    private AndroidDriver driver;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Some name");
        caps.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        caps.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), caps);
    }

    @Test
    public void sampleTestEmptyLine() {
        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el1.click();
        el1.sendKeys(" ");
        MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
        el3.click();
        Assertions.assertEquals("Hello UiAutomator!", el3.getText());
    }

    @Test
    public void sampleTestAnotherActivity() {
        MobileElement el4 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el4.click();
        el4.sendKeys("123");
        MobileElement el5 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/text");
        el6.click();
        Assertions.assertEquals(el4.getText(), el6.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

