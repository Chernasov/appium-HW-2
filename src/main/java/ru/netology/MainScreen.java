package ru.netology;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainScreen {

    @AndroidFindBy(id = "buttonChange")
    public MobileElement changeButton;

    @AndroidFindBy(id = "userInput")
    public MobileElement userInputField;

    @AndroidFindBy(id = "textToBeChanged")
    public MobileElement textToBeChanged;

    @AndroidFindBy(id = "buttonActivity")
    public MobileElement activityButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.TextView")
    public MobileElement textField;

    private AppiumDriver driver;

    public MainScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}
