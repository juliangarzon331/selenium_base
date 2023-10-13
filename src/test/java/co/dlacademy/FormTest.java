package co.dlacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTest {

    private WebDriver driver;
    @BeforeEach
    void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }
    @Test
    public void testSelect(){
        driver.manage().window().maximize();
        driver.get("https://automationtesting.co.uk/dropdown.html#");

        Select listaCarros = new Select(driver.findElement(By.id("cars")));
        listaCarros.selectByValue("bmw");
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.id("demo-priority-low"));
        if(element.isSelected()){
            System.out.println("Esta seleccionado");
        }else {
            executor.executeScript("arguments[0].click();", element);
        }


    }
}
