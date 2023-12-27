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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckingTheFilterFunctionality extends ParameterForTheFistTest{
	

	@BeforeTest
	public void TheSetUpOfTheWebSite() {
		TheSetUpOfTheWebSiteProcess();
	}

	@Test()
	public void CheckingTheFilterFunctionalityInScreenSection() throws InterruptedException {
		CheckingTheFilterFunctionalityWithAnAssertion();
	}

	@AfterTest
	public void End() {
	}
}
