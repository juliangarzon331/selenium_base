package co.dlacademy;

import co.dlacademy.page_object.ByDiplomado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSauceDemoTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Duration duracion;
    WebElement inputUsuario =  driver.findElement(By.id("user-name"));
    WebElement inputClave = driver.findElement(By.name("password"));
    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    @BeforeEach
    void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        duracion = Duration.ofSeconds(5);
        wait = new WebDriverWait(driver,duracion);

    }
    @Test
    public void loginEnSaucedemoExitosoConAtributos(){
        inputUsuario.sendKeys("standard_user");
        inputClave.sendKeys("secret_sauce");
        buttonLogin.click();
       driver.close();
    }

    //Metodos usando los webelement globales
    @Test
    public void loginEnSaucedemoExitosoConDatates(){
        inputUsuario.sendKeys("standard_user");
        inputClave.sendKeys("secret_sauce");
        buttonLogin.click();
        driver.close();
    }

    @Test
    public void loginEnSaucedemoBloqueadoConDatates(){
        inputUsuario.sendKeys("locked_out_user");
        inputClave.sendKeys("secret_sauce");
        buttonLogin.click();
        driver.close();
    }

    @Test
    public void loginEnSaucedemoProblemasDatates(){
        inputUsuario.sendKeys("problem_user");
        inputClave.sendKeys("secret_sauce");
        buttonLogin.click();
        driver.close();
    }

    @Test
    public void loginEnSaucedemoPerformConDatates(){
        inputUsuario.sendKeys("performance_glitch_user");
        inputClave.sendKeys("secret_sauce");
        buttonLogin.click();
        driver.close();
    }

    @Test
    public void loginEnSaucedemoErrorConDatates(){
        inputUsuario.sendKeys("error_user");
        inputClave.sendKeys("secret_sauce");
        buttonLogin.click();
        driver.close();
    }
}
