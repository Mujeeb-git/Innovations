package innovationsPortal;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class InnovationHomePage {

	
	WebDriver driver;

	@FindBy(xpath = "//*[@class='title ng-binding'][contains(text(),'Delivery Pride')]")
	WebElement deliveryPrideBtn;
	
	@FindBy(xpath = "//*[@class='title ng-binding'][contains(text(),'Client Co-Innovation')]")
	WebElement clientCoInnovationBtn;
		
	@FindBy(xpath = "//*[@class='title ng-binding'][contains(text(),'Innovation Contest')]")
	WebElement innovationContestBtn;
	
	@FindBy(xpath = "//*[@class='title ng-binding'][contains(text(),'Patent')]")
	WebElement patentBtn;
	
	@FindBy(xpath = "*//div/div[3]/div/div[2]/ul/li[2]/a")
	WebElement innovationsTab;
	
	@FindBy(xpath = "*//div/div[3]/div/div[2]/ul/li[3]/a")
	WebElement pendingApprovalsTab;
	
	@FindBy(xpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[1]/div[1]/i")
	WebElement expandDeliveryPride;
	
	@FindBy(xpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[2]/div/div[1]/i")
	WebElement expandDeliveryPride2;
	
	@FindBy(xpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[2]/div[2]/div/div[1]/i")
	WebElement expandDeliveryPride3;
	
	@FindBy(xpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/i")
	WebElement expandDeliveryPride4;
	
	@FindBy(xpath = "//*[@id=\"projectListTable\"]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]")
	WebElement deliveryPrideRequest;
	
	

	public InnovationHomePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	
}