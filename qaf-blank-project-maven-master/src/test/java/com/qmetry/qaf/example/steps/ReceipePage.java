package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.example.steps.HomePage.*;
import static com.qmetry.qaf.example.steps.SearchPage.*;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.qmetry.qaf.automation.step.QAFTestStep;

public class ReceipePage {
    
	/**
	 * @param saveRecipe
	 *            : save a recipe
	 */
	@QAFTestStep(description = "save a recipe")
	public static void saveRecipe() {
		waitForVisible("saveReceipeBtn.click");
		click("saveReceipeBtn.click");
		sleep();
	}

	/**
	 * @param verifyLoginMsg
	 *            : verify login message for unregistered user while save/review
	 */
	@QAFTestStep(description = "verify login message for unregistered user while save/review")
	public static void verifyLoginMsg() {
		waitForVisible("saveMessageText.verify");
		sleep();
		assertVisible("saveMessageText.verify");
	}
	
	/**
	 * @param clickReviewRecipe
	 *            : click on review btn
	 */
	@QAFTestStep(description = "click on review btn")
	public static void clickReviewRecipe() {
		waitForVisible("reviewBtn.click");
		click("reviewBtn.click");
		sleep();
	}

	/**
	 * @param writeReviewRecipe
	 *            : write a review
	 */
	@QAFTestStep(description = "write a review {0}")
	public static void writeReviewRecipe(String Review) {
		waitForVisible("writeReview.click");
		sendKeys(Review+Keys.ENTER, "writeReview.click");
		sleep();
	}
	
	/**
	 * @param verifySavedMsgForRegUser
	 *            : verify saved recipe msg for Reg User
	 */
	@QAFTestStep(description = "verify saved recipe msg for Reg User")
	public static void verifySavedMsgForRegUser() {
		waitForVisible("savedTxt.verify");
		assertVisible("savedTxt.verify");	
		sleep();
	}
	
	/**
	 * @param verifySavedRecipeName
	 *            : verify saved recipe name
	 */
	@QAFTestStep(description = "verify saved recipe name from Saves Link")
	public static void verifySavedRecipeName() {
		scrollUpPage();
		waitForVisible("savedRecipeTxt.verify");
		String savedRecipeName=getText("savedRecipeTxt.verify");
		System.out.println(savedRecipeName+"savedrecipe");
		navigateToRecipePage();
		clickSavesLink();
//		verifyLinkWithTextPresent(savedRecipeName);
		
		String savedRecipeNameFromList=getText("savesLinkRecipeName.verify");
		System.out.println(savedRecipeNameFromList+"savedrecipefrom list");
		Assert.assertEquals(savedRecipeName, savedRecipeNameFromList);
	}
	
	/**
	 * @param clickSavesLink
	 *            : click on Saves Link
	 */
	@QAFTestStep(description = "click on Saves Link")
	public static void clickSavesLink() {
		waitForVisible("savesLink.click");
		click("savesLink.click");

	}
}
