package innovationsPortal;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import innovationsPortal.ExcelHelp;

public class TestInnovation {

	ExcelHelp objExcelFile;
	String filePath, filePath2;
	int noOfRequests;
	WebDriver driver;
	InnovationHomePage objInnovationHomePage;
	DeliveryPridePage objDeliveryPridePage;
	String decryptedPassword, encryptedPassword;
	WebDriverWait wait;
	clientCoInnovationPage objclientCoInnovationPage;
	InnovationContestPage objInnovationsContestPage;
	PatentPage objPatentPage;

	@BeforeClass
	public void setUp() throws InterruptedException {

		// Create an object of ReadGuru99ExcelFile class
		objExcelFile = new ExcelHelp();

		// Prepare the path of excel file
		filePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\ExportExcel.xlsx";
		filePath2 = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\Delivery Pride_Artifact.pdf";

		System.setProperty("webdriver.ie.driver", "C:\\Mujeeb\\Jars\\chromedriver_win32\\chromedriver.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://digitalss.test.accenture.com/innovation/main.html#/");

		encryptedPassword = "TmV3bGlmZUA3";
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encryptedPassword);
		decryptedPassword = new String(decryptedPasswordBytes);
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@id=\"userNameInput\"]")).sendKeys("mujeeb.mohammed");
		driver.findElement(By.xpath("//*[@id=\"passwordInput\"]")).sendKeys(decryptedPassword);
		driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();
		wait = new WebDriverWait(driver, 120); // 30s timeout
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"bodyController\"][@class='delivery-sales-automation ng-scope']")));
		driver.navigate().to("https://digitalss.test.accenture.com/innovation/main.html#/");
		Thread.sleep(10000);

	}

	@Test(priority = 0)
	public void testDeliveryPride() throws Exception {

		// Call read file method of the class to read data
		// objExcelFile = new ExcelHelp(driver);
		// noOfRequests = objExcelFile.readExcel(filePath, "Sheet1", 1, 1);
		noOfRequests = 20;

		// Innovations home page
		objInnovationHomePage = new InnovationHomePage(driver);

		objInnovationHomePage.deliveryPrideBtn.click();
		Thread.sleep(10000);

		// Delivery Pride Page
		objDeliveryPridePage = new DeliveryPridePage(driver);

		objDeliveryPridePage.enterProjectName("Samsung");

		objDeliveryPridePage.choosePrideType("Credential Video");

		objDeliveryPridePage.choosePrideOutcome();

		objDeliveryPridePage.chooseConfidentiality("Internal Use");

		Thread.sleep(10000);
		Reporter.log("The file path for filePath2 is :" + filePath2, true);
		objDeliveryPridePage.chooseFile(filePath2);

		Thread.sleep(10000);

		objDeliveryPridePage.uploadBtn.click();
		Thread.sleep(50000);
		objDeliveryPridePage.saveBtn.click();
		Thread.sleep(50000);
	}

	@Test(priority = 1)
	public void clientCoInnovation() throws Exception {

		noOfRequests = 50;

		for (int i = 0; i < 50; i++) {
			// Innovations home page
			objInnovationHomePage = new InnovationHomePage(driver);

			objInnovationHomePage.clientCoInnovationBtn.click();
			Thread.sleep(10000);

			// Client innovationsPage
			objclientCoInnovationPage = new clientCoInnovationPage(driver);

			objclientCoInnovationPage.enterProjectName("Samsung");

			objclientCoInnovationPage.chooseIdeaSource("Workshop with client");

			objclientCoInnovationPage.chooseWorkShopType("For the Client");

			objclientCoInnovationPage.enterWorkShopDate("03/01/2018");

			objclientCoInnovationPage.chooseStatus("Idea Implemented");

			objclientCoInnovationPage.enterClientMembers("John, Smith");

			objclientCoInnovationPage.enterTopicOfDiscussion("TopicOfdiscussionName");

			objclientCoInnovationPage.enterIdeasGenerated("Ideas generated names");

			objclientCoInnovationPage.enterOutcome("OutcomeOfInnovation");

			objclientCoInnovationPage.enterIdeaTitle("Title of the Idea");

			objclientCoInnovationPage.selectIdeaOwner("sujay.kumar");

			objclientCoInnovationPage.enterNoOfIdeas("1");

			objclientCoInnovationPage.eligibleForCoiinovation("Yes");

			objclientCoInnovationPage.enterActivePursuit("Active pursuit");

			objclientCoInnovationPage.innovationWSclient("Yes");

			objclientCoInnovationPage.clientEndorsement("Yes");

			objclientCoInnovationPage.clientTestimony("Yes");

			objclientCoInnovationPage.clickSave();

			Thread.sleep(10000);
		}
	}

	@Test(priority=2)
	public void innovationContest() throws Exception {

		noOfRequests = 50;

		for (int i = 0; i < noOfRequests; i++) {
			// Innovations home page
			objInnovationHomePage = new InnovationHomePage(driver);
			Thread.sleep(10000);
			objInnovationHomePage.innovationContestBtn.click();
			Thread.sleep(10000);

			// Innovation Contest Page

			objInnovationsContestPage = new InnovationContestPage(driver);

			objInnovationsContestPage.enterProjectName("Samsung");

			objInnovationsContestPage.chooseContestType("Digi Shark");

			objInnovationsContestPage.enterTopic("Topic of the Innovation Contest");

			objInnovationsContestPage.enterNoOfIdeas("3");

			objInnovationsContestPage.enterNoOfParticipants("2");

			objInnovationsContestPage.enterNoOfIdeasFinalRound("2");

			objInnovationsContestPage.enterNoOfWinningIdeas("1");

			objInnovationsContestPage.enterNoOfPatentsFiled("1");

			objInnovationsContestPage.enterNoOfPatentsGranted("1");

			objInnovationsContestPage.clickSave();

			Thread.sleep(10000);
		}

	}

	@Test(priority=3)
	public void patent() throws Exception {

		noOfRequests = 50;

		for (int i = 0; i < noOfRequests; i++) {
			// Innovations home page
			objInnovationHomePage = new InnovationHomePage(driver);
			Thread.sleep(10000);
			objInnovationHomePage.patentBtn.click();
			Thread.sleep(10000);

			// Patent Page
			objPatentPage = new PatentPage(driver);

			objPatentPage.enterProjectName("Samsung");

			objPatentPage.enterPatentTitle("Title of the Patent");

			objPatentPage.enterInvestorName("sujaykumar");

			objPatentPage.choosePatentType("Filed");

			objPatentPage.enterPatentNumber("PN123456");

			objPatentPage.enterFilingNumber("FN123456");

			objPatentPage.chooseFilingApproved("Yes");

			objPatentPage.enterFilingGeography("Asia-Pacific");

			objPatentPage.enterLegalAttorney("asgar");

			objPatentPage.clickSave();

			Thread.sleep(10000);
		}

	}

}
