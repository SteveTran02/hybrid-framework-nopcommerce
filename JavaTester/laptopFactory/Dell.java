package laptopFactory;

public class Dell extends LaptopFactory {

	@Override
	protected void setLaptopName(String laptopName) {
		super.laptopName = laptopName;
	}

	@Override
	protected String getLaptopName() {
		return super.laptopName;
	}

}