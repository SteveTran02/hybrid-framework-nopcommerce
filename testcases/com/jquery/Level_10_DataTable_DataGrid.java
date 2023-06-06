package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

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

	public void Table_03_Get_Value_Row() {
		// Đọc data của file country.txt
		// Lưu vào List<String> -> expected value = expectedAllCountryValues

		actualAllCountryValue = homePage.getValueEachRowAtAllPage();

		// Verify
		Assert.assertEquals(actualAllCountryValue, expectedAllCountryValues);
	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		// homePage.clickToLoadDataButton();
		// homePage.sleepInSecond(3);
		/*
		 * Parameters 1_ Column name: Company/ Contact person/ Order placed 2_ Row number 3_ data value
		 */

		// Send key to textbox
		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "Bosch");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "1", "Robert Bosch");
		// select to default drop down list
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Germany");
		// uncheck to check box
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "1", "99");

		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "2", "CMC GLobal");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "2", "Van");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Taiwan");
		// check to check box
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "2", "100");

		homePage.enterToTextboxByColumnNameAtRowNumber("Company", "3", "Logigear");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "3", "Tuan");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "3", "United Kingdom");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "3", "101");

		// click icon name: Insert Row Above/ Remove Current Row/ Move Up/ Move Down
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.clickToIconByRowNumber("2", "Move Down");

		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;
	List<String> actualAllCountryValue;
	List<String> expectedAllCountryValues;
}
