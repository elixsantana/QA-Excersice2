

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Scanner;

public class UITest {

	public static void main(String[] args) throws InterruptedException {
	
		System.out.println("This test uses Google Chrome browser\n");
		
		System.out.println("Enter path for chromedriver.exe");
		System.out.println("C:\\Users\\Administrator\\Documents\\chromedriver.exe");	
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String path = input.replace("\\", "\\\\");
		System.setProperty("webdriver.chrome.driver", path);  //"C:\\Users\\Administrator\\Documents\\chromedriver.exe"
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.practiceselenium.com");
		driver.manage().window().maximize();
		
		//Testing LoadPage
	   Assert.assertEquals(driver.getTitle(), "Welcome");
	   System.out.println("Page loaded. Passed\n");
		
	   
	   //Testing Checkout Webform
	    System.out.println("Checkout form");
		driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("elix_Santana@hotmail.com");;
        driver.findElement(By.id("name")).sendKeys("-125");
        driver.findElement(By.id("address")).sendKeys("Calle 27 de Febrero #150");
        
        driver.findElement(By.className("btn-primary")).click();
		
        try {
        	driver.findElement(By.className("btn-primary")).click();
        	System.out.println("Input accepted. TEST SUCCESSFUL");
        } catch (NoSuchElementException e) {
        	System.out.println("Input not handled. TEST FAILED. Modify your Place order routine");
        }
        
        
        Thread.sleep(500);
        
      //Testing Let's talk tea Webform submit
        driver.get("http://www.practiceselenium.com");
        
        driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[4]/a")).click();
        driver.findElement(By.name("name")).sendKeys("-125");
    	driver.findElement(By.name("email")).sendKeys("elix_Santana@hotmail.com");;
        driver.findElement(By.name("subject")).sendKeys("Test");
        driver.findElement(By.name("message")).sendKeys("Test");
		
        System.out.println("\nLet's talk tea Form");
        
        try {
        	driver.findElement(By.className("submit")).click();
        	System.out.println("Test Passed");
        } catch (NoSuchElementException e) {
        	System.out.println("Input not handled. TEST FAILED. Modify your Submit routine");
        }
        
        
        Thread.sleep(500);	 
		driver.quit();
		}

	
	}


