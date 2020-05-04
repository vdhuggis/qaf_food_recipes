package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.example.steps.SearchPage.*;

import org.openqa.selenium.Keys;

import com.qmetry.qaf.automation.step.QAFTestStep;

public class HomePage {
	
	/**
	 * @param navigateToRecipePage
	 *            : navigate to recipe page
	 */
	@QAFTestStep(description = "navigate to recipe page")
	public static void navigateToRecipePage() {
		waitForVisible("recipeLink.click");
		click("recipeLink.click");
	}
	
	/**
	 * @param navigateToSearchPage
	 *            : navigate to search page
	 */
	@QAFTestStep(description = "navigate to search page")
	public static void navigateToSearchPage() {
		waitForVisible("recipe.search");
		click("recipe.search");
		waitForVisible("recipetype.search");
	}
	
	/**
	 * @param SignInUser
	 *            : login as Reg User
	 */
	@QAFTestStep(description = "login as Reg User {0} {1}")
	public static void SignInUser(String userName, String password){
		waitForVisible("signInBtn.click");
		click("signInBtn.click");
		waitForVisible("logInBtn.click");
		click("logInBtn.click");
		waitForVisible("emailTxt.click");
		click("emailTxt.click");
		sendKeys(userName, "emailTxt.click");
		waitForVisible("pwdTxt.click");
		click("pwdTxt.click");
		sendKeys(password+Keys.ENTER, "pwdTxt.click");
		sleep();
	}
	
}
