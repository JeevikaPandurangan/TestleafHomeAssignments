package assignment.week4.day2.actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) {
	
		    ChromeDriver driver = new ChromeDriver();
		  	driver.manage().window().maximize();
		  	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://jqueryui.com/selectable/");
			driver.switchTo().frame(0);
			WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
			WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
			WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
			WebElement item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
			Actions builder = new Actions(driver);
			builder.keyDown(Keys.CONTROL).click(item1).click(item3).click(item5).click(item6).keyUp(Keys.CONTROL).perform();
		
	}

}
