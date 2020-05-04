package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.waitForEnabled;

import org.testng.Assert;

import com.qmetry.qaf.automation.step.QAFTestStep;

public class StepsLibrary {
	/**
	 * @param navigateToRecipes
	 *            : navigate To Recipes page
	 */
	@QAFTestStep(description = "navigate To Recipes page")
	public static void navigateToRecipes() {
		waitForEnabled("button.recipe");
		click("button.recipe");
	}
	
	@QAFTestStep(description = "navigate To Recipes page")
	public static void validation() {
		Assert.assertEquals("text.recipe", "RECIPES");
	}
	
	/**
	 * @param clickSearchButton
	 *            : click Search Button
	 */
	@QAFTestStep(description = "click Search Button")
	public static void clickSearchButton() {
		waitForEnabled("button.search");
		click("button.search");
		waitForEnabled("input.searchAttr");
	}
	
	/**
	 * @param searchTerm
	 *            : search term to be searched
	 */
	@QAFTestStep(description = "search for {0}")
	public static void searchForRecipe(String searchTerm) {
		sleep();
		sendKeys(searchTerm, "input.searchAttr");
		sleep();
		sleep();
		click("input.searchIcon");
		sleep();
	}
	
	/**
	 * @param sleep
	 *            : sleep
	 */
	@QAFTestStep(description = "sleep")
	public static void sleep() {
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
