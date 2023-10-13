package co.dlacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Duration duracion;
    @BeforeEach
    void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }

    @Test
    public void testAlert(){

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Alert alertConfirmacion = driver.switchTo().alert();
        alertConfirmacion.accept();
    }

    @Test
    public void testAlertWait(){
        duracion = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver,duracion);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertConfirmacion = driver.switchTo().alert();
        alertConfirmacion.accept();
    }


}
