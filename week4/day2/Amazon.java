package assignment.week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Load the uRL https://www.amazon.in/

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		System.out.println("Title of Home page :"+driver.getTitle());
		
		// search as oneplus 9 pro 
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		System.out.println("Title of resulting page :"+driver.getTitle());
		
		// Get the price of the first product
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of first product :"+price);
		
		// Print the number of customer ratings for the first displayed product
		String rating = driver.findElement(By.xpath("(//span[@class=\"a-size-base s-underline-text\"])[1]")).getText();
		System.out.println("Customer rating : " + rating);

		// Mouse Hover on the stars
		WebElement ratings = driver.findElement(By.xpath("(//span[@data-action='a-popover'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ratings).build().perform();
		action.click(ratings).perform();

		Thread.sleep(2000);
		
		// Get the percentage of ratings for the 5 star.
    	WebElement ratingTable = driver.findElement(By.xpath("//div[@class='a-row a-spacing-medium']//following::table"));
		List<WebElement> rows = ratingTable.findElements(By.tagName("tr"));
		List<WebElement> columnsList = null;

		for (WebElement row : rows) {
			columnsList = row.findElements(By.tagName("td"));
			for (WebElement column : columnsList) {
				System.out.println("percentage :");
				System.out.print(column.getText()+" ");
			}

		}
		
		// Click the first text link of the first image
		driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")).click();
		
		Set<String> windowHandles=  driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		WebDriver window = driver.switchTo().window(list.get(1));
		System.out.println("Title of resulting page :"+window.getTitle());
		
		// Take a screen shot of the product displayed
		  //Take a snapshot
          File source = driver.getScreenshotAs(OutputType.FILE);        
          //Create folder to save the img file
          File desc=new File("snaps/phone.png");
          //Merge source and destination
          FileUtils.copyFile(source, desc);
        
		// Click 'Add to Cart' button
        driver.findElement(By.id("add-to-cart-button")).click();
          
		// Get the cart subtotal and verify if it is correct.
          String subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
          if(price.equals(subtotal)) {
        	  System.out.println("correct");
          }
          else {
        	  System.out.println("not correct");
          }
          driver.switchTo().defaultContent();
          driver.quit();
	}

}
