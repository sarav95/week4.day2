package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropP {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		WebElement eleDrag = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement eleDrop = driver.findElement(By.xpath("//p[text()='Drop here']"));
		Actions obj=new Actions(driver);
		obj.dragAndDrop(eleDrag, eleDrop).perform();
		driver.close();
		
	}
}
