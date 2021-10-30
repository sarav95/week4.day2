package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		WebElement eleOsz = driver.findElement(By.xpath("//div[@style=\"z-index: 90;\"][3]"));
		Actions obj=new Actions(driver);
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeClickable(eleOsz));
		obj.clickAndHold(eleOsz).moveByOffset(305,55).release().perform();
		driver.close();
		
	
		
	}

}
