package LeaveReport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Leave {
	public static WebDriver driver;
	public static Actions actions;
	public static int numOfRows;
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
		actions.moveToElement(driver.findElement(By.xpath("//span[text()='My Leave']/parent::a"))).click().build().perform();
		
		/*
		 * selecting the leave status check box as "Cancelled" and getting the total number of result rows. 
		 * and comparing  the status of each row with "Cancelled"
		 */
		numOfRows=selectLeaveStatusCheckBox("//label[text()='Cancelled']/following-sibling::input");
		resultStatusVerification("Cancelled",numOfRows,6);
		actions.moveToElement(driver.findElement(By.xpath("//label[text()='Cancelled']/following-sibling::input"))).click().build().perform();
		
		/*
		 * selecting the leave status check box as "Rejected" and getting the total number of result rows. 
		 * and comparing  the status of each row with "Rejected"
		 */		
		numOfRows=selectLeaveStatusCheckBox("//label[text()='Rejected']/following-sibling::input");
		resultStatusVerification("Rejected",numOfRows,6);
		actions.moveToElement(driver.findElement(By.xpath("//label[text()='Rejected']/following-sibling::input"))).click().build().perform();
		
		/*
		 * selecting the leave status check box as "Pending Approval" and getting the total number of result rows. 
		 * and comparing  the status of each row with "Pending Approval"
		 */		
		numOfRows=selectLeaveStatusCheckBox("//label[text()='Pending Approval']/following-sibling::input");
		resultStatusVerification("Pending Approval",numOfRows,6);
		actions.moveToElement(driver.findElement(By.xpath("//label[text()='Pending Approval']/following-sibling::input"))).click().build().perform();
		
		/*
		 * selecting the leave status check box as "Scheduled" and getting the total number of result rows. 
		 * and comparing  the status of each row with "Scheduled"
		 */		
		numOfRows=selectLeaveStatusCheckBox("//label[text()='Scheduled']/following-sibling::input");
		resultStatusVerification("Scheduled",numOfRows,6);
		actions.moveToElement(driver.findElement(By.xpath("//label[text()='Scheduled']/following-sibling::input"))).click().build().perform();
		
		/*
		 * selecting the leave status check box as "Taken" and getting the total number of result rows. 
		 * and comparing  the status of each row with "Taken"
		 */		
		numOfRows=selectLeaveStatusCheckBox("//label[text()='Taken']/following-sibling::input");
		resultStatusVerification("Taken",numOfRows,6);
		actions.moveToElement(driver.findElement(By.xpath("//label[text()='Taken']/following-sibling::input"))).click().build().perform();
		
		
		driver.close();
		
		
	}
	public static int selectLeaveStatusCheckBox(String xpathOfCheckBox)
	{
		int numOfRows=0;
		if(driver.findElement(By.xpath("//label[text()='All']/following-sibling::input")).isSelected())
	
		{
			actions.moveToElement(driver.findElement(By.xpath("//label[text()='All']/following-sibling::input"))).click().build().perform();
		}
		
		//driver.findElements(By.xpath("//div[@id='leaveList_chkSearchFilter_checkboxgroup']/input")).clear();
		actions.moveToElement(driver.findElement(By.xpath(xpathOfCheckBox))).click().build().perform();
		
		actions.moveToElement(driver.findElement(By.xpath("//input[@id='btnSearch']"))).click().build().perform();
		boolean b=false;
		try {
			b=driver.findElement(By.xpath("//td[text()='No Records Found']")).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b)
		{
			numOfRows=0;
		}
		else
		{
		numOfRows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr")).size();
		}
		return numOfRows;
	}
	public static void resultStatusVerification(String status,int numOfRows,int col_position)
	{
		int numOfMatchedRows=0;
		//System.out.println(numOfRows);
		if(numOfRows==0)
		{
			System.out.println("there are no records with status '"+status+"'");
	    }
		else
		{
			for(int i=1;i<=numOfRows;i++)
			{
				String statusColumnData=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td["+col_position+"]")).getText();
				//System.out.println("the coulumn data "+statusColumnData);
				statusColumnData=statusColumnData.substring(0, statusColumnData.length()-6);
				//System.out.println("the coulumn data after trimming "+statusColumnData);
				if(statusColumnData.equalsIgnoreCase(status))
				{
					numOfMatchedRows++;
				}
				else
				{
					System.out.println("the status in the "+i+"th row is not matiching with the expected status '"+status+"'.");
					System.out.println("the Actual status in the "+i+"th row is '"+statusColumnData+"'");
				}
			}
			if(numOfMatchedRows==numOfRows)
			{
				System.out.println("Status of all records ("+numOfRows+") got by search is '"+status+"'");
			}
			else
			{
				System.out.println("Status of all records ("+numOfRows+") got by search is not '"+status+"'");
			}

		}
	}
	

}
