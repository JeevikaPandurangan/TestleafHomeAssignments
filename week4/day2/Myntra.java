package assignment.week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws IOException {
	

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		System.out.println("Title of Home page :"+driver.getTitle());
		
		// Mouse hover on MeN 
		WebElement men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();
		
		// Click Jackets 
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		System.out.println("Title of resulting page :"+driver.getTitle());
		
		// Find the total count of item 
		String total = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total count :"+total);
		
		// Check jackets
		driver.findElement(By.xpath("//label[text()='Jackets']")).click();
		
		// Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
	    // Type Duke and click checkbox
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[text()='Duke']")).click();
		
		// Close the pop-up x
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		// Confirm all the Coats are of brand Duke - Hint : use List 
		List<WebElement> duke = driver.findElements(By.xpath("//h3[@class='product-brand']"));
	    System.out.println("Duke Size : "+duke.size());
		
		// Sort by Better Discount
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		builder.moveToElement(sort).perform();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		
		// Find the price of first displayed item
		String price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("The price of first product :"+price);
		
		// Click on the first product
		driver.findElement(By.xpath("(//li[@class='product-base']/a)[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		System.out.println("Title of resulting page :"+driver.getTitle());
		// Take a screen shot

	    	 //Take a snapshot
             File source = driver.getScreenshotAs(OutputType.FILE);        
            //Create folder to save the img file
            File desc=new File("snaps/myntra.png");
            //Merge source and destination
            FileUtils.copyFile(source, desc);
		
		// Click on WishList Now
            driver.findElement(By.xpath("//div[contains(@class,' pdp-add-to-wishlist pdp-button pdp-add-to-wishlist pdp-button pdp-flex pdp-center')]")).click();
            
		// Close Browser
            driver.quit();

    

	}

}
