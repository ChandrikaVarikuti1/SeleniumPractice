package FBsignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbSignIn {
	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C://drivers//chromedriver_win321//chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		isElementDisplayed(email,"Email or PhoneNumber");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='pass']"));
		isElementDisplayed(password,"Password");
		
		WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']"));
		isElementDisplayed(firstname,"Firstname");
		
		WebElement surname=driver.findElement(By.xpath("//input[@name='lastname']"));
		isElementDisplayed(surname,"SurName");
		
		WebElement mailOrPhone=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		isElementDisplayed(mailOrPhone,"Email or Phone number");
		
		WebElement Password=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		isElementDisplayed(Password,"Password");
		
		WebElement birthDayDate=driver.findElement(By.xpath("//select[@name='birthday_day']"));
		isElementDisplayed(birthDayDate,"birthDayDate");
		
		WebElement birthDayMonth=driver.findElement(By.xpath("//select[@name='birthday_month']"));
		isElementDisplayed(birthDayMonth,"birthDayMonth");
		
		WebElement birthDayYear=driver.findElement(By.xpath("//select[@name='birthday_year']"));
		isElementDisplayed(birthDayYear,"birthDayYear");
		
		WebElement gender_female=driver.findElement(By.xpath("//label[text()='Female']/preceding-sibling::input"));
		isElementDisplayed(gender_female,"gender_female");
		
		WebElement gender_male=driver.findElement(By.xpath("//label[text()='Male']/preceding-sibling::input"));
		isElementDisplayed(gender_male,"gender_male");
		
		WebElement gender_Custom=driver.findElement(By.xpath("//label[text()='Custome']/preceding-sibling::input"));
		isElementDisplayed(gender_Custom,"gender_Custom");
		
		WebElement Signup=driver.findElement(By.xpath("//button[@name='websubmit']"));
		isElementDisplayed(Signup,"gender_Custom");
		
	}
	
	public static void isElementDisplayed(WebElement element, String elementName)
	{
		if(element.isDisplayed())
		{
			System.out.println("the "+elementName+" is displayed on facebook login ");
		}	
		else
		{
			System.out.println("the "+elementName+" is not displayed on facebook login ");
		}
	}
	

}
