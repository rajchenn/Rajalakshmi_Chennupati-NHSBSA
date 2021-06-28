package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage 
{
	public WebDriver driver;
	
	@FindBy(how = How.ID, using = "label-yes")
	private WebElement yesRadioBtn;
	
	@FindBy(how = How.ID, using = "label-no")
	private WebElement noRadioBtn;
	
	@FindBy(how = How.ID, using = "next-button")
	private WebElement nextBtn;
	
	public  BasePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void selectYesRadioBtn() 
	{
    	yesRadioBtn.click();
    }
	
	public void selectNoRadioBtn() 
	{
		noRadioBtn.click();
    }
	
	public void clickNextBtn()
	{
		nextBtn.click();
	}


}
