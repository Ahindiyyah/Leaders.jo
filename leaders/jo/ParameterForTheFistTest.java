package leaders.jo;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ParameterForTheFistTest {
	WebDriver driver = new ChromeDriver();
	String WebSite = "https://leaders.jo/en/samsung/";
	Random rand = new Random();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public void TheSetUpOfTheWebSiteProcess() {
		driver.get(WebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void CheckingTheFilterFunctionalityWithAnAssertion() throws InterruptedException {
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		WebElement ScreensButton = driver
				.findElement(By.xpath("//*[@id=\"post-205872\"]/div/section/div[4]/div[2]/div/div/div[1]/figure/a"));
		ScreensButton.click();
		Set<String> Handles = driver.getWindowHandles();
		Iterator it = Handles.iterator();
		String ParentId = (String) it.next();
		String ChildId = (String) it.next();
		driver.switchTo().window(ChildId);
		WebElement FilterButton = driver.findElement(By.xpath("//select[@name='orderby']"));
		FilterButton.click();
		Select select = new Select(FilterButton);
		select.selectByIndex(3);
		Thread.sleep(2000);
		WebElement PriceOfTheFirstItem = driver
				.findElement(By.xpath("//*[@id=\"main\"]/ul/li[1]/div/div/div[3]/div[1]/span/span/span/bdi"));
		String TheActualPriceOfTheFirstItem = PriceOfTheFirstItem.getText().replace("JOD", "").replace(",", ".")
				.replace(".00", "");
		TheActualPriceOfTheFirstItem = TheActualPriceOfTheFirstItem.trim();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1300)");
		WebElement PriceOfTheLastItem = driver
				.findElement(By.xpath("//*[@id=\"main\"]/ul/li[15]/div/div/div[3]/div[1]/span/span/span/bdi"));
		String TheActualPriceOfTheLastItem = PriceOfTheLastItem.getText().replace("JOD", "").replace(",", ".")
				.replace(",", ".").replace(".00", "");
		TheActualPriceOfTheLastItem = TheActualPriceOfTheLastItem.trim();
		double TheActualPriceOfTheFirstItemIntger = Double.parseDouble(TheActualPriceOfTheFirstItem);
		double TheActualPriceOfTheLastItemInteger = Double.parseDouble(TheActualPriceOfTheLastItem);
		boolean IsTheComparsionRight = TheActualPriceOfTheFirstItemIntger > TheActualPriceOfTheLastItemInteger;
		Assert.assertEquals(IsTheComparsionRight, true);
	}
}
