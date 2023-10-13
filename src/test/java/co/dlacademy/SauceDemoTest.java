package co.dlacademy;

import co.dlacademy.page_object.ByDiplomado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static co.dlacademy.utils.HandleData.convertirStringDobleSinSigno;


public class SauceDemoTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Duration duracion;
    @BeforeEach
    void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        duracion = Duration.ofSeconds(5);
        wait = new WebDriverWait(driver,duracion);

    }

    @Test
    public void loginEnSauceDemoExistoso() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //wait.until(ExpectedConditions.alertIsPresent());
        //driver.switchTo().alert().accept();
        driver.findElement(By.id("item_4_title_link")).click();
        //btn_primary btn_inventory
        driver.findElement(By.xpath("//button[contains(@class,'btn')]")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']")).click();
        driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();
        driver.findElement(ByDiplomado.dataTest("firstName")).sendKeys("standard_user");
        driver.findElement(ByDiplomado.dataTest("lastName")).sendKeys("standard_user");
        driver.findElement(ByDiplomado.dataTest("postalCode")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
        driver.findElement(By.xpath("//a[@class='btn_action cart_button']")).click();
        String mensajeExito = driver.findElement(By.xpath("//h2[contains(@class,'complete')]")).getText();

        Assertions.assertEquals(mensajeExito, "THANK YOU FOR YOUR ORDER");
        driver.quit();

    }

    @Test
    public void loginEnSauceDemoExistosoElements() throws InterruptedException {
        String precio ;
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> precioProductos = driver.findElements(By.className("inventory_item"));

        for (int i = 0; i<precioProductos.size();i++){
            precio=precioProductos.get(i).findElement(By.className("inventory_item_price")).getText();
            if("$15.99".equals(precio)){
                    System.out.println("Hola");
                    precioProductos.get(i).findElement((By.className("btn"))).click();
            }
        }
        System.out.println(precioProductos.size());
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void loginEnSauceDemoExistosoElementsChallenge() throws InterruptedException {
        String precio ;
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        List<WebElement> precioProductos = driver.findElements(By.className("inventory_item"));

        for (int i = 0; i<precioProductos.size();i++){
            precio=precioProductos.get(i).findElement(By.className("inventory_item_price")).getText();
            //precio=precio.replace("$","");
            if(convertirStringDobleSinSigno(precio)<20.00){
                System.out.println("Hola");
                precioProductos.get(i).findElement((By.className("btn"))).click();
            }
        }
        System.out.println(precioProductos.size());
        Thread.sleep(15000);
        driver.quit();

    }



    @Test
    public void loginEnSauceDemoExistosoConDataTest(){
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(ByDiplomado.dataTest("username")).sendKeys("standard_user");
        driver.findElement(ByDiplomado.dataTest("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.close();

    }


}
