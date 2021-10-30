package week4.day2.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.AbstractParallelWorker.Arguments;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebElement mBrands = driver.findElement(By.xpath("//a[text()='brands']"));
		WebElement lOreal = driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]"));
		Actions obj=new Actions(driver);
		obj.moveToElement(mBrands).moveToElement(lOreal).click().perform();
		String tit = driver.getTitle();
		if (tit.contains("L'Oreal Paris")) {
			System.out.println("Title Matched");
		}
		WebElement eleScr = driver.findElement(By.xpath("//p[contains(text(),'But with')] "));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();",eleScr);
		WebElement DrpSort = driver.findElement(By.xpath("//span[text()='Sort By : popularity']"));
		DrpSort.click();
		WebElement topRate = driver.findElement(By.xpath("//span[text()='customer top rated']"));
		topRate.click();
		WebElement eleCate = driver.findElement(By.xpath("//span[text()='Category']"));
//		eleCate.click();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(20));
		w.until(ExpectedConditions.elementToBeClickable(eleCate));
//		js.executeScript("arguments[0].scrollIntoView();",topRate);
		eleCate.click();
//		js.executeScript("arguments[0].scrollIntoView();",topRate);
		WebElement eleHair= driver.findElement(By.xpath("//span[text()='Hair']"));
		w.until(ExpectedConditions.elementToBeClickable(eleHair));
		eleHair.click();	
		WebDriverWait w1=new WebDriverWait(driver,Duration.ofSeconds(40));
		WebElement elehCare = driver.findElement(By.xpath("//span[text()='Hair Care']"));
		w1.until(ExpectedConditions.elementToBeClickable(elehCare));
		elehCare.click();
		WebElement eleShamp = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		w1.until(ExpectedConditions.elementToBeClickable(eleShamp));
		eleShamp.click();
		WebElement eleconCern = driver.findElement(By.xpath("//span[text()='Concern']"));
		eleconCern.click();
		WebElement colProtect = driver.findElement(By.xpath("//span[text()='Color Protection']"));
		colProtect.click();
		WebElement cheFil = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		if (cheFil.getText().contains("Shampoo")) {
			System.out.println("filter applied");
		}
		WebElement eleLoreal = driver.findElement(By.xpath("//img[@alt=\"L'Oreal Paris Colour Protect Shampoo\"]"));
		eleLoreal.click();
		Set<String> winHand=driver.getWindowHandles();
		List<String> winLis=new ArrayList<String>(winHand);
		driver.switchTo().window(winLis.get(1));
		WebElement eleDrop=driver.findElement(By.xpath("//select[@class=\"css-18yinz8\"]"));
		Select drop=new Select(eleDrop);
		drop.selectByValue("0");
		WebElement mrp = driver.findElement(By.xpath("//span[contains(text(),'150')]"));
		System.out.println(mrp.getText());
		WebElement btnBag = driver.findElement(By.xpath("(//button/span[text()='ADD TO BAG'])[1]"));
		btnBag.click();
		Set<String> winHand1=driver.getWindowHandles();
		List<String> winLis1=new ArrayList<String>(winHand1);
		System.out.println(winLis1.size());
		driver.switchTo().window(winLis1.get(1));
		WebElement btnCart = driver.findElement(By.xpath("//span[@class=\"cart-count\"]"));
		btnCart.click();
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
//		driver.switchTo().frame(0);
		WebElement eleGrand = driver.findElement(By.xpath("(//div[@class=\"value\"])[4]"));
		w1.until(ExpectedConditions.visibilityOf(eleGrand));
		String text = eleGrand.getText();
		System.out.println(text);
		String substring = text.substring(1,text.length());
		System.out.println(substring);
		WebElement btnProceed = driver.findElement(By.xpath("//span[text()='Proceed']"));
		w.until(ExpectedConditions.elementToBeClickable(btnProceed));
		btnProceed.click();
		Set<String> winHand2=driver.getWindowHandles();
		List<String> winLis2=new ArrayList<String>(winHand2);
		System.out.println(winLis2.size());
		driver.switchTo().window(winLis2.get(1));
		WebElement guest = driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']"));
		guest.click();
		Set<String> winHand3=driver.getWindowHandles();
		List<String> winLis3=new ArrayList<String>(winHand3);
		System.out.println(winLis3.size());
		driver.switchTo().window(winLis3.get(1));
		WebElement gra = driver.findElement(By.xpath("//div[@class=\"payment-details-tbl grand-total-cell prl20\"]//span"));
		System.out.println(gra.getText());
		if (substring.contains(gra.getText())) {
			driver.quit();
		}
	}

}
