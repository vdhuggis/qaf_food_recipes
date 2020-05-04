package com.qmetry.qaf.example.steps;
import static com.qmetry.qaf.automation.step.CommonStep.*;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

public class SearchPage {
	
	/**
	 * @param searchRecipe
	 *            : search recipe
	 */
	@QAFTestStep(description = "search recipe {0}")
	public static void searchRecipe(String keyword) {
		waitForVisible("recipetype.search");
		click("recipetype.search");		
		sendKeys(keyword+Keys.ENTER, "recipetype.search");
		sleep();	
	}
	
	/**
	 * @param selectPizzaRecipe
	 *            : select a recipe
	 */
	@QAFTestStep(description = "select a recipe")
	public static void selectPizzaRecipe() {
		waitForVisible("pizzaRecipeImg.click");
		click("pizzaRecipeImg.click");
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
	
	/**
	 * @param verifyNoMatchMsg
	 *            : verify no match message
	 */
	@QAFTestStep(description = "verify no match message")
	public static void verifyNoMatchMsg() {
		waitForVisible("noMatchRecipeMsg.verify");
		assertVisible("noMatchRecipeMsg.verify");
	}
	
	/**
	 * @param scrollDownToBottom
	 *            : scroll to bottom of the page
	 */
	@QAFTestStep(description = "scroll to bottom of the page")
	public static void scrollDownToBottom() {
		WebDriverTestBase	d= new WebDriverTestBase();
	    QAFExtendedWebDriver driver=d.getDriver();
	    JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	/**
	 * @param scrollUpPage
	 *            : scroll to top of the page
	 */
	@QAFTestStep(description = "scroll to top of the page")
	public static void scrollUpPage() {
	WebDriverTestBase	d= new WebDriverTestBase();
	QAFExtendedWebDriver driver=d.getDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver ;
	js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		
	}
	
	/**
	 * @param verifyResultCount
	 *            : verify result count
	 */
	@QAFTestStep(description = "verify result count")
	public static void verifyResultCount() {
		waitForVisible("resultCountText.verify");
		scrollDownToBottom();
		WebDriverTestBase	d= new WebDriverTestBase();
		QAFExtendedWebDriver driver=d.getDriver();
		List<WebElement> results=driver.findElementsByXPath("//h2/a[@href[contains(.,'/recipe/')]]");
		assertText("resultCountText.verify",String.valueOf(results.size())+" RESULTS");
	}
}
