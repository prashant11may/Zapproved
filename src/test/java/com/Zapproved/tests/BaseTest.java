package com.Zapproved.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Zapproved.pages.PageCollection;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropertiesConfig;

public class BaseTest {

	String CurrentDir = System.getProperty("user.dir");
	protected String PathToInput1 = CurrentDir + "/Resources/Files/companyLogo1.png";
	protected String PathToInputPNG = CurrentDir + "/Resources/Files/InputPNG.png";

	protected PropertiesConfig prop;

	protected BaseTest() {
		prop = ConfigFactory.create(PropertiesConfig.class);

	}

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public PageCollection pages;

	public ExtentTest test;

	// Launch the Bowser

	@BeforeMethod
	public void SetUp() throws MalformedURLException {
		System.out.println("In Base setup, you have choosed to run the system as " + prop.Execution());
		if (Objects.isNull(driver.get())) {
			if (prop.Execution().trim() == "Remote") {
				URL url = new URL("http://localhost:4444/wd/hub");
				DesiredCapabilities des = DesiredCapabilities.chrome();
				driver.set(new RemoteWebDriver(url, des));

				driver.get().manage().window().maximize();

			} else {

				System.out.println("In local setup");
				WebDriverManager.chromedriver().setup();
				ChromeOptions options;

				options = new ChromeOptions();
//				options.addArguments("--headless");// "Headless Chrome"
				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				driver.set(new ChromeDriver(options));
				System.out.println(driver.get());
				driver.get().manage().window().maximize();

			}
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void initialie() {
		System.out.println("Initialized page collection");
		pages = new PageCollection(driver);

	}

	// Close The Browser

	@AfterMethod(alwaysRun = true)
	public void TearDown(ITestResult res) {
		System.out.println("inside teardown");

		if (Objects.nonNull(driver.get())) {
			driver.get().close();
			driver.get().quit();
			driver.remove();
		}

	}

	// ScreenShot

	public static String TakeScreenshot(String TestName, WebDriver driver) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(System.getProperty("user.dir") + "\\Report\\" + TestName + ".png");
		FileUtils.copyFile(SrcFile, DestFile);

		return System.getProperty("user.dir") + "\\Report\\" + TestName + ".png";

	}

}