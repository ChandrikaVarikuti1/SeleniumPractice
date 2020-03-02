package TableHeader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HeaderVerifier {

	
		public static WebDriver driver;
		public static Actions actions;
		public static Select select;
		
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C://drivers//chromedriver_win321//chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://testingmasters.com/hrm/symfony/web/index.php/auth/login");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			//gggygsiodi
			
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("User02");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("TM1234");
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			Thread.sleep(1000);
			
			actions=new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//a[@id='menu_leave_viewLeaveModule']"))).build().perform();
			actions.moveToElement(driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']"))).click().build().perform();
			
			String expectedHeaders[]={"Date","Employee Name","Leave Type","Leave Balance ","Number of Days","Status","Comments","Actions"};
			
			int numOfColumns=driver.findElements(By.xpath("//table/thead/tr/th")).size();
			String[] ActualHeaders = new String[numOfColumns];
			for(int i=1;i<=numOfColumns;i++)
			{
				String s=driver.findElement(By.xpath("//table/thead/tr/th["+i+"]/span")).getText().trim();
				//System.out.println(s);
				ActualHeaders[i-1]=s;
			}
			//System.out.println(ActualHeaders.length);
			
			for(int i=0;i<=numOfColumns-1;i++)
			{
				if(ActualHeaders[i].equals(expectedHeaders[i]))	
				{
					System.out.println("the ActualHeader "+ActualHeaders[i]+" at the "+i+"th position of the result table is matched with the expectedHeader"+expectedHeaders[i]);
				}
				else
				{
					System.out.println("the ActualHeader "+ActualHeaders[i]+" at the "+i+"th position of the result table is not matched with the expectedHeader"+expectedHeaders[i]);
				}
			}
			driver.close();

	}

		

}
