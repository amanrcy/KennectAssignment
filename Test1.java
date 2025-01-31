package Assignment.Task1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void setup() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@Test
	public void valid_login() throws InterruptedException {
		try {
			driver.get("https://gor-pathology.web.app/dashboard");

			// Login
			driver.findElement(By.name("email")).sendKeys("test@kennect.io");
			driver.findElement(By.name("password")).sendKeys("Qwerty@1234");
			driver.findElement(By.className("MuiButton-label")).click();

			// Navigate to Tests
			WebElement tests = driver
					.findElement(By.xpath("//*[@id='root']/div/nav/div[2]/div/div/div/div[2]/ul/a[2]/div/div[2]/span"));
			tests.click();

			// Click Add Patient
			WebElement addPatientButton = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='root']/div/main/div[2]/div[1]/a[2]/button/span[1]")));
			addPatientButton.click();

			// Enter Patient Details
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[1]")))
					.sendKeys("Aman Yadav");
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[2]")))
					.sendKeys("amanyadav7236jnp@gmail.com");
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]")))
					.sendKeys("8104131481");

			// Click Generate Button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='General Details'])[2]")))
					.click();

			// Enter Secondary Details
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='height']")))
					.sendKeys("170");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='weight']")))
					.sendKeys("55");

			// Select Gender
			WebElement dropdown = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("mui-component-select-gender")));
			dropdown.click();
			List<WebElement> options = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li")));
			for (WebElement option : options) {
				if (option.getText().equals("Male")) {
					option.click();
					break;
				}
			}

			// Enter Age and Blood Pressure
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[@name='age']")))
					.sendKeys("20");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//input[@name='systolic']")))
					.sendKeys("90");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='diastolic']")))
					.sendKeys("60");

			// Add Tests
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text()='Add Tests']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("patient-test"))).click();
			Thread.sleep(3000);

			// Select AFP Test
			WebElement checkbox = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[text()='AFP (ALPHA FETO PROTEINS)']")));
			if (!checkbox.isSelected())
				checkbox.click();
			Thread.sleep(3000);

			// Select Discount
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]//div)[3]"))).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@role='option'])[2]"))).click();
			Thread.sleep(3000);

			// Select Lab Recommendation
			wait.until(ExpectedConditions.elementToBeClickable(By.id("patient-tests-labs"))).click();
			Thread.sleep(3000);
			WebElement labCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[text()[normalize-space()='HEALTHCARE PATHOLOGY (Sion) - AFP (ALPHA FETO PROTEINS) - 180₹']]")));
			if (!labCheckbox.isSelected())
				labCheckbox.click();
			Thread.sleep(1000);

			// Select Doctor Recommendation
			WebElement doctor = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]")));
			doctor.click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='MuiAutocomplete-option'])[1]")))
					.click();
			Thread.sleep(1000);

			// Select Doctor Commission
			wait.until(ExpectedConditions.elementToBeClickable(By.id("mui-component-select-doctor_commission")))
					.click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@role='option'])[2]"))).click();
			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait for Add Equipment button and click
			WebElement addEquipment = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
					"#root > div > main > div.MuiContainer-root.MuiContainer-maxWidthLg > div.MuiPaper-root.MuiCard-root.jss106.MuiPaper-elevation1.MuiPaper-rounded > div > div.MuiBox-root.jss136 > div.MuiBox-root.jss144 > div > div:nth-child(1) > div > div.jss152 > div > div > span > button")));
			js.executeScript("arguments[0].scrollIntoView(true);", addEquipment);
			Actions actions = new Actions(driver);
			actions.moveToElement(addEquipment).click().perform();

			// Wait for Plus Button and click
			WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
					"#root > div > main > div.MuiContainer-root.MuiContainer-maxWidthLg > div.MuiPaper-root.MuiCard-root.jss106.MuiPaper-elevation1.MuiPaper-rounded > div > div.MuiBox-root.jss136 > div.MuiBox-root.jss144 > div > div.jss156 > div > div > div > table > tbody > tr:nth-child(1) > td.MuiTableCell-root.MuiTableCell-body.MuiTableCell-paddingNone > div > button:nth-child(1)")));
			js.executeScript("arguments[0].scrollIntoView(true);", plusButton);
			actions.moveToElement(plusButton).click().perform();

			// Wait for Add Button and click
			WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiButton-root')]//span)[3]")));
			js.executeScript("arguments[0].scrollIntoView(true);", addButton);
			actions.moveToElement(addButton).click().perform();

			// Optionally wait for some result or element to appear
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation-element")));

			System.out.println("Test Passed: The action was successful.");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Test Failed: There was an issue with the test.");
		} finally {
			if (driver != null) {
				driver.quit();
				System.out.println("Test completed and browser closed.");
			}
		}
	}
}
