package assignment.week4.day2.actionclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Menu {

	public static void main(String[] args) {
		
	    ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/menu.xhtml");
//		driver.findElement(By.xpath("//li[@class='ui-widget ui-menuitem ui-corner-all ui-menu-parent ui-menuitem-active']")).click();
//	    WebElement newoption = driver.findElement(By.xpath("(//a[@class='ui-menuitem-link ui-submenu-link ui-corner-all'])[2]"));
//	    Actions builder = new Actions(driver);
//        builder.moveToElement(newoption).perform();
//	    WebElement addcustomer = driver.findElement(By.xpath("(//a[@class='ui-menuitem-link ui-corner-all'])[1]"));
//	    builder.moveToElement(addcustomer).perform();
// 	    builder.contextClick().perform();
		WebElement rightclick = driver.findElement(By.xpath("//h5[text()='Context Menu']"));
        Actions  builder=new Actions(driver);
		builder.contextClick(rightclick).perform();
		
   

	}

}
