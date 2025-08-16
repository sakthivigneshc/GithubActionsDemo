package githubActionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleHomePage {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("Https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
		System.out.println("Entered the value");
		driver.close();
		
		
	}

}
