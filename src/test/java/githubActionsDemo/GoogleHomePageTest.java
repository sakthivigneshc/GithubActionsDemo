package githubActionsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleHomePageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");   // required for GitHub Actions
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void searchGoogle() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        Assert.assertTrue(
            title.toLowerCase().contains("selenium"),
            "Title does not contain 'Selenium'. Actual title: " + title
        );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
