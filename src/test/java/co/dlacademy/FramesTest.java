package co.dlacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramesTest {

    private WebDriver driver;

    @BeforeEach
    void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }

    @Test
    public void testFrame(){
        String textoFrame;
        String textoFrame2;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        textoFrame = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(textoFrame);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame2");
        textoFrame2 = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(textoFrame2);
        driver.switchTo().defaultContent();


    }
}
