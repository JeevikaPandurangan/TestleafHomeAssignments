package assignment.week4.day2.actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Droppable {

	public static void main(String[] args) {
		
		    ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://jqueryui.com/droppable/");
			driver.switchTo().frame(0);
			WebElement source = driver.findElement(By.xpath("//div[@class='ui-widget-content ui-draggable ui-draggable-handle']"));
			WebElement destination = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));
		    Actions builder = new Actions(driver);
		    builder.dragAndDrop(source, destination).perform();
		    System.out.println(destination.getText());
		    driver.close();

	}

}
