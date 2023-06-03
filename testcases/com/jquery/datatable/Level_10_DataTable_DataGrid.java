package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass()
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("9");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("9"));

		homePage.openPagingByPageNumber("2");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("2"));

		homePage.openPagingByPageNumber("10");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingByPageNumber("9");
		homePage.sleepInSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("9"));
	}

	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxByLabel("Country", "Australia");
		homePage.enterToHeaderTextboxByLabel("Females", "145412");
		homePage.enterToHeaderTextboxByLabel("Males", "154696");
		homePage.enterToHeaderTextboxByLabel("Total", "300109");
		homePage.sleepInSecond(3);

		homePage.enterToHeaderTextboxByLabel("Country", "Germany");
		homePage.enterToHeaderTextboxByLabel("Females", "389997");
		homePage.enterToHeaderTextboxByLabel("Males", "410337");
		homePage.enterToHeaderTextboxByLabel("Total", "800337");
	}

	@Test
	public void Table_03_Get_Value_Row() {
		homePage.getValueEachRowAtAllPage();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;
}
