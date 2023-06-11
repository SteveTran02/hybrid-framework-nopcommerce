package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_12_Upload_Files extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Uploads_01_One_File_Per_Time() {
		// Step 01 - Load single file
		homePage.uploadMultipleFiles(driver, caoHungFileName);
		// Step 02 - Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(caoHungFileName));
		// Step 03 - Click to Start button
		homePage.clickToStartButton();
		// Step 04 - Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(caoHungFileName));
		// Step 05 - Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(caoHungFileName));
	}

	@Test
	public void Uploads_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);

		// Step 01 - Load multiple file
		homePage.uploadMultipleFiles(driver, caoHungFileName);
		homePage.uploadMultipleFiles(driver, daiNameFileName);
		homePage.uploadMultipleFiles(driver, taipeiFileName);
		// Step 02 - Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(caoHungFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(daiNameFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(taipeiFileName));
		// Step 03 - Click to Start button
		homePage.clickToStartButton();
		// Step 04 - Verify single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(caoHungFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(daiNameFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(taipeiFileName));
		// Step 05 - Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(caoHungFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(daiNameFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(taipeiFileName));
	}

	@AfterTest(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;
	String caoHungFileName = "caohung.jpg";
	String daiNameFileName = "dainam.jpg";
	String taipeiFileName = "taipei.jpg";
	String fileNames[] = { caoHungFileName, daiNameFileName, taipeiFileName };
}
