package javaBasic;

public class Topic_14_String_Format {

	// 4 page => 4 locator variable
	public static String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";

	// 1 dynamic variable => define n locator
	public static String DYNAMIC_SIDEBAR_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']";

	// 1 locator để đại diện cho các Page (Header, sidebar, footer)
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";

	public static void main(String[] args) {
		clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME, "Customer info");
		clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME, "Addresses");
		clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME, "Reward points");
		clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME, "My product reviews");

		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper	", "Sitemap");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Reward points");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "My product reviews");

	}

	// 1 tham số động
	// public static void clickToLink(String locator) {
	// System.out.println("Click to: " + locator);
	// }

	// 2 tham số động
	// public static void clickToLink(String dynamicLocator, String pageName) {
	// // dynamicLocator = //div[contains(@class,'account-navigation')]//a[text()='%s']
	// // %s = Customer info .... Page name
	// String locator = String.format(dynamicLocator, pageName);
	// System.out.println("Click to: " + locator);
	// }

	// 3 tham số động
	// public static void clickToLink(String dynamicLocator, String areaName, String pageName) {
	// String locator = String.format(dynamicLocator, areaName, pageName);
	// System.out.println("Click to: " + locator);
	// }

	// 1-n tham số động
	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to: " + locator);
	}

}
