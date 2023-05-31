package assignment.week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundTable {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://leafground.com/table.xhtml");
//		WebElement table = driver.findElement(By.xpath("(//table[@role='grid'])[2]"));
		List<WebElement> row = driver.findElements(By.xpath("(//table[@role='grid'])[2]/tbody/tr"));
		List<WebElement> col = driver.findElements(By.xpath("(//table[@role='grid'])[2]/tbody/tr/td"));
		System.out.println("Rows: "+row.size()+" Columns: "+col.size());
	    for (WebElement rows : row) {
			System.out.println("Table content : "+rows.getText());
			}
		

	}

}
