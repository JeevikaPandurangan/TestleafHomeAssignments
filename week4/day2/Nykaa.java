package assignment.week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		
		// Mouseover on Brands and Search L'Oreal Paris
		System.out.println("Title of Home page : "+driver.getTitle());
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		
		// Click L'Oreal Paris
		driver.findElement(By.xpath("(//a[contains(text(),'Paris')])[1]")).click();
		
		// Check the title contains L'Oreal Paris(Hint-GetTitle)
		System.out.println("Title of L'Oreal Paris : "+driver.getTitle());
		if(driver.getTitle().contains("Paris")) {
			System.out.println("The title contains L'Oreal Paris");
		}
		else {
			System.out.println("The title doesn't contain L'oreal paris");
		}
		
		// Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		// Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']")).click();
		
		// Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']")).click();
		
		// check whether the Filter is applied with Shampoo
		String verify = driver.findElement(By.xpath("//div[@class='css-rtde4j']")).getText();
		if(verify.contains("Shampoo")) {
			System.out.println("Shampoo filter is applied");
		}
		else {
			System.out.println("Shampoo filter is not applied");
		}
		
		// Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect')]")).click();
		
		// GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		
		// Print the MRP of the product
		String mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
		System.out.println("The MRP of the Product:"+mrp);
		
		// Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		
		// Go to Shopping Bag 
		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		
		// Print the Grand Total amount
		driver.switchTo().frame(0);
		String grandtotal = driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']")).getText();
		System.out.println("The Grand Total: "+grandtotal);
		
		// Click Proceed
		driver.findElement(By.xpath("(//button[@class='css-1j2bj5f e8tshxd0'])[2]")).click();
		driver.switchTo().defaultContent();
		
		// Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']")).click();
		
		// Check if this grand total is the same in step 14
		String check = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
		System.out.println(check);
		
		if(grandtotal==check) {
			System.out.println("Both Same");
		}
		else {
			System.out.println("Price not match");
		}
		
		// Close all windows
		driver.quit();

	}

}
