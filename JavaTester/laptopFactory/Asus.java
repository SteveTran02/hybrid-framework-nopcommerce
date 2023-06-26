package laptopFactory;

public class Asus extends LaptopFactory {

	@Override
	protected void setLaptopName(String laptopName) {
		super.laptopName = laptopName;
	}

	@Override
	protected String getLaptopName() {
		return super.laptopName;
	}

	private void setConfig() {
		settingConfig();
	}

}
