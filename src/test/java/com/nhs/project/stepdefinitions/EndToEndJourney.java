package com.nhs.project.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import envReader.EnvReader;
import pageObjects.*;

public class EndToEndJourney 
{
	WebDriver driver = Hooks.driver;
	
	@Given("^I navigate to NHS eligibility checker tool$")
	public void i_navigate_to_NHS_eligibility_checker_tool() throws Throwable 
	{
		System.out.println("windows chrome3");
		driver.get(EnvReader.getProperty("Base_URL")); // Navigate to the NHS eligibility checker tool
		driver.findElement(By.id("nhsuk-cookie-banner__link_accept_analytics")).click();
		
	}

	@Given("^I am a person from Wales$")
	public void i_am_a_person_from_Wales() throws Throwable 
	{
		NhsStartPage nhsStartPage = new NhsStartPage(driver);
		nhsStartPage.clickNextBtn();
		
		CountryPage countryPage = new CountryPage(driver);
		countryPage.clickOnWalesRadioBtn(); 
		countryPage.clickNextBtn();
	}

	@When("^I put my circumstances into the Checker tool$")
	public void i_put_my_circumstances_into_the_Checker_tool() throws Throwable 
	{
		DateOfBirthPage dob = new DateOfBirthPage(driver);
		dob.enterDateOfBirth("30", "03", "1961");
		dob.clickNextBtn();
		
		DoYouLiveWithAPartner liveWithAPartner = new DoYouLiveWithAPartner(driver);
		liveWithAPartner.selectYesRadioBtn();
		liveWithAPartner.clickNextBtn();
		
		DoYouOrYourPartnerCliamAnyBenefitsOrTaxCredits youOrYourPartnerCliamAnyBenefitsOrTaxCredits = new DoYouOrYourPartnerCliamAnyBenefitsOrTaxCredits(driver);
		youOrYourPartnerCliamAnyBenefitsOrTaxCredits.selectNoRadioBtn();
		youOrYourPartnerCliamAnyBenefitsOrTaxCredits.clickNextBtn();
		
		PregnantPage pregnantPage = new PregnantPage(driver);
		pregnantPage.selectYesRadioBtn();
		pregnantPage.clickNextBtn();
		
		InjuryOrIllnessPage injuryOrIllnessPage = new InjuryOrIllnessPage(driver);
		injuryOrIllnessPage.selectNoRadioBtn();
		injuryOrIllnessPage.clickNextBtn();

		CareHomePage careHomePage = new CareHomePage(driver);
		careHomePage.selectNoRadioBtn();
		careHomePage.clickNextBtn();
		
		SavingsPage savingsPage = new SavingsPage(driver);
		savingsPage.selectNoRadioBtn();
		savingsPage.clickNextBtn();
		
	}

	@Then("^I should get a result of whether I will get help or not$")
	public void i_should_get_a_result_of_whether_I_will_get_help_or_not() throws Throwable 
	{
		ResultsPage resultsPage = new ResultsPage(driver);
		String heading = resultsPage.getHeading();
		
		Assert.assertTrue(heading.equalsIgnoreCase("Based on what you've told us\n" + 
				"You get help with NHS costs"), "Not Result Page");
	}

	
}
