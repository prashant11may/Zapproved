package com.Zapproved.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	PageCollection pages;

	public BasePage(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}

	public WebElement waitforPresenceOFElement(By locator) {
		System.out.println();
		WebElement firstResult = new WebDriverWait(driver.get(), 60)
				.until(ExpectedConditions.presenceOfElementLocated(locator));
		return firstResult;

	}

	public void waitforPresenceOFElementUntilCLickable(By locator) {
		// System.out.println();
		try {
			WebElement firstResult = new WebDriverWait(driver.get(), 60)
					.until(ExpectedConditions.elementToBeClickable(locator));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void MoveToElement(By Locator) {
		Actions act = new Actions(driver.get());
		act.moveToElement(driver.get().findElement(Locator)).build().perform();
	}

	public void clickandwait(By locator) {
		try {
			WebElement firstResult = new WebDriverWait(driver.get(), 60)
					.until(ExpectedConditions.elementToBeClickable(locator));
			firstResult.click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void ClickUsingActionClass(By locator) {
		WebElement el = driver.get().findElement(locator);
		new Actions(driver.get()).click(el).build().perform();
		System.out.println("element has been clicked");
	}

	public void Clickandwait(By locator) {
		waitforelementtoBecomePresent(locator);
		waitforelementtoBecomeclickable(locator);
		driver.get().findElement(locator).click();
	}

	public void SeTText(By locator, String keysToSend) {

		waitforelementtoBecomeVisible(locator);

		WebElement el = waitforPresenceOFElement(locator);
		el.sendKeys(keysToSend);
	}

	public void switchTab(int i) {
		ArrayList<String> tabs = new ArrayList<String>(driver.get().getWindowHandles());

		driver.get().switchTo().window(tabs.get(i));
	}

	public void waitforelementtoBecomePresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 60);
			WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void waitforelementtoBecomeclickable(By locator) {

		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 20);
			WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element is not clickable yet ");
			e.printStackTrace();
		}

	}

	public WebElement waitforelementtoBecomeclickable(WebElement el) {

		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 20);
			WebElement el1 = wait.until(ExpectedConditions.elementToBeClickable(el));
			return el1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element is not clickable yet ");
			e.printStackTrace();
			return null;
		}

	}

	public void waitforelementtoBecomeVisible(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 60);
			WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean waitforelementtoBecomeInVisible(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 60);
			Boolean el = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return el;
		} catch (Exception e) {
			// TODO: handle exception

			return false;

		}
	}

	public WebElement waitforvisibility(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 60);
			WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return el;
		} catch (Exception e) {
			// TODO: handle exception

			return null;

		}
	}

	public void SetText(By locator, String text) {
		waitforelementtoBecomePresent(locator);
		waitforelementtoBecomeclickable(locator);
		driver.get().findElement(locator).clear();
		driver.get().findElement(locator).sendKeys(text);
	}

	public void handleAlert() {
		if (isAlertPresent()) {
			Alert alert = driver.get().switchTo().alert();
			System.out.println("Alert Text is" + alert.getText());
			alert.accept();
		}
	}

	public void handleAlertDismiss() {
		if (isAlertPresent()) {
			Alert alert = driver.get().switchTo().alert();
			System.out.println("Alert Text is" + alert.getText());
			alert.dismiss();
		}
	}

	/**
	 * Checks if is alert present.
	 *
	 * @return True if JavaScript Alert is present on the page otherwise false
	 */
	public boolean isAlertPresent() {
		try {
			driver.get().switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	public void SelectFromDropDown(By locator, String NameOfOption) {

		waitforelementtoBecomeclickable(locator);
		Select sel = new Select(driver.get().findElement(locator));
		// sel.selectByValue(NameOfOption);
		sel.selectByIndex(0);

	}

	public void SelectFromDropDownUsingNameOfOption(By locator, String NameOfOption) {

		waitforelementtoBecomeclickable(locator);
		Select sel = new Select(driver.get().findElement(locator));
		// sel.selectByValue(NameOfOption);
		sel.selectByVisibleText(NameOfOption);

	}

	public void SelectFromDropDownUsingConsumerInterface(Consumer<Select> consumer, By element) {

		consumer.accept(new Select(driver.get().findElement(element)));

	}

	public String GetSelectedValueFromDropdown(By locator) {
		waitforelementtoBecomeVisible(locator);
		return new Select(driver.get().findElement(locator)).getFirstSelectedOption().getText();
	}

	public String GetText(By locator) {
		waitforelementtoBecomeclickable(locator);
		return driver.get().findElement(locator).getText().trim();
	}

	public void SelectByUsingVisibleText(By locator, String text) {
		waitforelementtoBecomeclickable(locator);
		Select sel = new Select(driver.get().findElement(locator));
		sel.selectByVisibleText(text);

	}

	public void SelectFromDropDownUsingIndex(By element, int Index) {

		waitforelementtoBecomeclickable(element);
		Select sel = new Select(driver.get().findElement(element));
		// sel.selectByValue(NameOfOption);

		sel.selectByIndex(Index);
		sel.getOptions();

	}

	public void PerFormActionUsingActionsClass(Consumer<Actions> consumer) {

		consumer.accept(new Actions(driver.get()));
	}

	public String getAttribute(By locator, String NameOfAttribute) {
		return driver.get().findElement(locator).getAttribute(NameOfAttribute);

	}

	public boolean IsElementPresent(By locator) {
		return driver.get().findElement(locator).isDisplayed();
	}

	public boolean isElementPresent(By locatorKey) {
		try {
			Sleep(3);
			driver.get().findElement(locatorKey);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementVisible(String cssLocator) {
		return driver.get().findElement(By.cssSelector(cssLocator)).isDisplayed();
	}

	public List<WebElement> ReturnListOfElements(By locator) {
		return driver.get().findElements(locator);
	}

	public void PressEnter(By locator) {

		driver.get().findElement(locator).sendKeys(Keys.RETURN);
	}

	public void PressEnter() {

		Actions act = new Actions(driver.get());
		act.sendKeys(Keys.RETURN).build().perform();

	}

	public void MouseHover(By locator) {
		WebElement ele = driver.get().findElement(locator);
		Actions actions = new Actions(driver.get());
		actions.moveToElement(ele).perform();
		Sleep(3);
	}

	public void PressEnterByUsingAlert() {
		Alert al = driver.get().switchTo().alert();
		al.accept();
	}

	public final void javascriptButtonClick(By webElement) {
		WebElement el = driver.get().findElement(webElement);
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("arguments[0].click();", el);
		System.out.println("javascript button has been clicked.");
	}

	public void Sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void MultipleCheckBoxSelector(By Buttonlocator, By optionLocator) {

		waitforelementtoBecomeVisible(Buttonlocator);
		clickandwait(Buttonlocator);

		waitforelementtoBecomeVisible(optionLocator);
		clickandwait(optionLocator);

	}

	public void DoubleClick(By locator) {

		WebElement el = driver.get().findElement(locator);
		new Actions(driver.get()).doubleClick(el).build().perform();
	}

	public void InputFiles(By locator, String PathName) {
		WebElement chooseFile = driver.get().findElement(locator);
		chooseFile.sendKeys(PathName);
	}

	public final void waitTillAlertPresent() {
		try {

			WebDriverWait wait = new WebDriverWait(driver.get(), 60);
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.get().switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException noAlert) {
			noAlert.getMessage();
		}
	}

	public void AllHeaders(By locator) { // OVERVIEW Table List Item Prints
		List<WebElement> allHeaders = (List<WebElement>) driver.get().findElement(locator);
		System.out.println("allHeaders");
		for (WebElement e : allHeaders) {
			System.out.println(e);
		}
	}

	public void FindADesiredElementFromTable(By locator) {
		WebElement DesiredElement = driver.get().findElement(locator);
		waitforelementtoBecomeclickable(locator);
		System.out.println(DesiredElement);
		DesiredElement.click();
	}

	public void changeStatus(By locator) {

		waitforelementtoBecomeclickable(locator);

		String CurrentStatus = new Select(driver.get().findElement(locator)).getFirstSelectedOption().getText();
		List<WebElement> li = new Select(driver.get().findElement(locator)).getOptions();

		loop: for (WebElement el : li) {

			if (CurrentStatus.equals(el.getText())) {

			} else {
				SelectFromDropDownUsingConsumerInterface(e -> e.selectByVisibleText(el.getText()), locator);

				waitTillAlertPresent();
				waitforLoaderToAppear();
				break loop;

			}
		}

	}

	public void SetStatusOfCheckBox(String Status, WebElement el) {

		if (Status.toUpperCase().startsWith("U")) {
			if (ReturnStatusOFCheckbox(el)) {
				el.click();

			} else {

				System.out.println("Checkbox is already unchecked.");

			}

		}

		else if (Status.toUpperCase().startsWith("C")) {
			if (ReturnStatusOFCheckbox(el)) {
				System.out.println("Checkbox is already selected.");

			} else {
				el.click();
			}
		}

	}

	public boolean ReturnStatusOFCheckbox(WebElement Locator) {

		return Locator.isSelected();
	}

	public void SelectStatusFilter(By locator, String Filter, String Status) {
		waitforelementtoBecomePresent(locator);
		clickandwait(locator);

		WebElement el = waitforelementtoBecomeclickable(driver.get().findElement(locator)
				.findElement(By.xpath("//following-sibling::ul//label[contains(text(),'" + Filter + "')]//input")));

		SetStatusOfCheckBox(Status, el);

	}

	public void waitforLoaderToAppear() {
		By loader = By.xpath("//*[name()='circle' and contains(@class,'ng-star-in')]");
		waitforelementtoBecomeVisible(loader);
	}

	public void waitforLoaderToDisAppear() {
		By loader = By.xpath("//*[name()='circle' and contains(@class,'ng-star-in')]");
		waitforelementtoBecomeInVisible(loader);
	}

	public void chooseStatus(By locator, String Status) {

		waitforelementtoBecomeVisible(locator);

		String CurrentStatus = new Select(driver.get().findElement(locator)).getFirstSelectedOption().getText();
		List<WebElement> li = new Select(driver.get().findElement(locator)).getOptions();

		loop: for (WebElement el : li) {

			if (CurrentStatus.equals(el.getText())) {

			} else {

				SelectFromDropDownUsingConsumerInterface(e -> e.selectByVisibleText(Status), locator);

				handleAlert();
				break loop;
			}
		}
	}

	public void selectExternalStatus(By locator, String Status) {
		Select status = new Select(driver.get().findElement(locator));
		status.selectByVisibleText(Status);
	}

	public boolean FieldIsEnable(By locator) {

		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 3);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			// System.out.println("Field Is Enable");
			return true;

		} catch (Exception e) {
			// System.out.println("Field Is Disable");
			return false;
		}
	}

	public final Set<String> getAllWindowsName() {
		return driver.get().getWindowHandles();
	}

	public final String getCurrentWindow() {
		return driver.get().getWindowHandle();
	}

	public final void switchToWindowByName(String windowName) {
		driver.get().switchTo().window(windowName);
	}

	public void SwitchToNewWindow() {
		String currentWindow = getCurrentWindow();
		System.out.println("name of new window======================>>>>>>>" + currentWindow);
		new WebDriverWait(driver.get(), 30).until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windows = getAllWindowsName();
		for (String Wi : windows) {
			if (!Wi.equals(currentWindow)) {
				System.out.println("switched to new window================================>>>>>>>>>>" + Wi);
				switchToWindowByName(Wi);
			}
		}
	}

	public final void switchToOriginalWindow() {
		driver.get().switchTo().window(getCurrentWindow());
	}

	public void IncreaseScreenSize() {
		WebElement html = driver.get().findElement(By.tagName("body"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
	}

	public void DecreaseScreenSize() {
		new Actions(driver.get()).sendKeys(Keys.CONTROL).sendKeys("-").keyUp(Keys.CONTROL).build().perform();
	}

	public void pressDownArrowKey(By locator) {
		driver.get().findElement(locator).sendKeys(Keys.ARROW_DOWN);

	}

	public boolean scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("arguments[0].scrollIntoView();", driver.get().findElement(locator));
		if (driver.get().findElement(locator).isDisplayed()) {
			return true;
		}
		return false;
	}

	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver.get();
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

	}

}
