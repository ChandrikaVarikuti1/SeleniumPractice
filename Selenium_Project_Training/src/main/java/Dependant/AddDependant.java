package Dependant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddDependant{

	public static WebDriver driver;
	public static Actions actions;
	public static Select select;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://drivers//chromedriver_win321//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://testingmasters.com/hrm/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("User02");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("TM1234");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(1000);
		
		actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Dependents']"))).click().build().perform();
		actions.moveToElement(driver.findElement(By.xpath("//input[@id='btnAddDependent']"))).click().build().perform();
		
		String dependant_name="Maanya";
		String dependant_DateOfBirth="2018-11-02";
		String dependant_relation="Child";
		
		driver.findElement(By.xpath("//input[@id='dependent_name']")).sendKeys(dependant_name);
		driver.findElement(By.xpath("//select[@id='dependent_relationshipType']")).click();
		
		//actions.moveToElement(driver.findElement(By.xpath("//select[@id='dependent_relationshipType']/option[text()='Child']"))).click().build().perform();
		
		select=new Select(driver.findElement(By.xpath("//select[@id='dependent_relationshipType']")));
		
		select.selectByVisibleText(dependant_relation);
		driver.findElement(By.xpath("//input[@id='dependent_dateOfBirth']")).clear();
		
		driver.findElement(By.xpath("//input[@id='dependent_dateOfBirth']")).sendKeys(dependant_DateOfBirth);
		
		driver.findElement(By.xpath("//input[@id='btnSaveDependent']")).click();
		
		int numOfDependants=driver.findElements(By.xpath("//table/tbody/tr")).size();
		//int numOfColumns=driver.findElements(By.xpath("//table/tbody/tr[1]/td")).size();
		
		String name="";
		String relation="";
		String dateOfBirth="";
		boolean flag=false;
		for(int i=1;i<numOfDependants;i++)
		{
			name=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td/a")).getText();
			if(name.equals(dependant_name))
			{
				relation=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText().trim();
				dateOfBirth=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText().trim();
				System.out.println(relation);
				System.out.println(dateOfBirth);
				if(relation.equalsIgnoreCase(dependant_relation)&&dateOfBirth.equalsIgnoreCase(dependant_DateOfBirth))
				{
					flag=true;
					System.out.println("the dependant details which are added previously, were present in the dependants list ");
				}
				break;
			}
		}
		if(!flag)
		{
			System.out.println("the dependant details which are added previously, were not present in the dependants list ");
		}
		
		
		
	}

}
