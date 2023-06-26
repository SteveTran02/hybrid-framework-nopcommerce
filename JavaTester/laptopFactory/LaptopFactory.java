package laptopFactory;

public abstract class LaptopFactory {

	protected String laptopName;

	protected abstract void setLaptopName(String laptopName);

	protected abstract String getLaptopName();

	// Non-abstract
	protected void settingConfig() {
		System.out.println("Ram = ");
		System.out.println("SSD = ");
		System.out.println("HDD = ");

	}
}
