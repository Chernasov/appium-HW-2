package ru.netology;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChangeTextTest {

    private AndroidDriver driver;
    private String textToSet = "Netology";

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 2 API 30");
        desiredCapabilities.setCapability("appium:app", "D:\\Project\\appium-HW-2\\debug\\app-debug.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void testChangeTextWithEmpty() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.changeButton.click();
        Assertions.assertEquals("Hello UiAutomator!", mainScreen.textToBeChanged.getText());

    }

    @Test
    public void testChangeTextWithSpace() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.userInputField.sendKeys(" ");
        mainScreen.changeButton.click();
        Assertions.assertEquals("Hello UiAutomator!", mainScreen.textToBeChanged.getText());
    }

    @Test
    public void testChangeTextInNewActivity() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.userInputField.sendKeys(textToSet);
        mainScreen.activityButton.click();
        Assertions.assertEquals(textToSet, mainScreen.textField.getText());
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}

