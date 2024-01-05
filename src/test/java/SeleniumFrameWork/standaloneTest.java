package SeleniumFrameWork;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class standaloneTest 
{
	
	public static void main(String[] args)
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("jagadish@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Qwer1234");
		driver.findElement(By.id("login")).click();
		List<WebElement> products= driver.findElements(By.cssSelector(".fa-shopping-cart"));
		WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		driver.close();
	}

}
