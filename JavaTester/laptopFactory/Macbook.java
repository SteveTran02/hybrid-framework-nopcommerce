package laptopFactory;

public class Macbook extends LaptopFactory {

	@Override
	protected void setLaptopName(String laptopName) {
		super.laptopName = laptopName;
	}

	@Override
	protected String getLaptopName() {
		return super.laptopName;
	}

}