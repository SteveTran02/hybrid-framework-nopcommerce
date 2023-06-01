package commons;

import java.io.File;

public class GlobalConstants {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";

	// System info
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");

	// Download/ Upload file
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";

	// Browser Logs/Extension
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + File.separator + "browserExtensions";

	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragAndDrop";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";

	// Database/ User/ Pass
	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_DEV_USER = "pureinsight";
	public static final String DB_DEV_PASS = "pureinsight";
	public static final String DB_TEST_URL = "32.18.252.185:9860";
	public static final String DB_TEST_USER = "pureinsight";
	public static final String DB_TEST_PASS = "pureinsight";

	// Wait Info
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;

	// Retry Case Failed
	public static final long RETRY_TEST_FAIL = 3;
}
