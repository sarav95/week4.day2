package week4.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MulSel {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		//single select element.
		WebElement eleFirst =driver.findElement(By.xpath("//li[text()='Item 1']"));
		Actions obj =new Actions(driver);
		obj.moveToElement(eleFirst).click().perform();
		//group select
		WebElement eleFour = driver.findElement(By.xpath("//li[text()='Item 4']"));
		obj.clickAndHold(eleFirst).moveToElement(eleFour).release().perform();
		driver.close();
	}
}
