package assignment.week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTag {

	public static void main(String[] args) {
		
//Assignments 2
		
        //1. Launch the URL https://html.com/tags/table/
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://html.com/tags/table/");
		
		//Table 
		WebElement table1 = driver.findElement(By.xpath("//div[@class='render']/table"));
		//2. Get the count of number of rows
		List<WebElement> row1 = table1.findElements(By.tagName("tr"));
		System.out.println("Table1 (Row) : "+row1.size());
		//3. Get the count of number of columns
		List<WebElement> col1 = table1.findElements(By.tagName("th"));
		System.out.println("Table1 (Column) : "+col1.size());
		
		
//Assignment 3 
		for (WebElement row : row1) {
			System.out.println("Rows data: "+row.getText());
		}
		
	}

}
