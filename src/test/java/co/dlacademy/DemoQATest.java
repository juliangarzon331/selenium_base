package co.dlacademy;

import co.dlacademy.page_object.ByDiplomado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQATest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Duration duracion;
    //WebElement buttonStart = driver.findElement(By.id("startStopButton"));

    @BeforeEach
    void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        duracion = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver,duracion);
    }


    @Test
    public void testWaitsImplict(){
        String barraProgreso;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(duracion);
        driver.get("https://demoqa.com/progress-bar");
        driver.findElement(By.id("startStopButton")).click();
        barraProgreso = driver.findElement(By.xpath("//div[@role='progressbar' and contains (.,'100')]")).getText();
        driver.findElement(By.id("resetButton")).click();
        System.out.println(barraProgreso);


    }

    @Test
    public void testWaitsExplicit() throws InterruptedException {
        String barraProgreso;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/progress-bar");
        driver.findElement(By.id("startStopButton")).click();
       barraProgreso=
                wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.
                        xpath("//div[@role='progressbar' and contains (.,'100')]"))).getText();
        System.out.println(barraProgreso);
        driver.findElement(By.id("resetButton")).click();



    }
}
