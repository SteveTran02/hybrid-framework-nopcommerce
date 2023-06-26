package laptopFactory;

public interface LaptopFactoryInterface {
	public static final String laptopName = "Hello to Laptop World";

	public abstract void setLaptopName(String laptopName);

	public abstract String getLaptopName();
}
