package laptopFactory;

public class Customer {

	public static void main(String[] args) {
		LaptopFactory laptopFactory;
		// Asus store
		laptopFactory = getLaptop("Asus");
		laptopFactory.setLaptopName("Asus gaming TUF DASH");
		System.out.println(laptopFactory.getLaptopName());

		laptopFactory.setLaptopName("Asus gaming ROG TRIX");
		System.out.println(laptopFactory.getLaptopName());

		// Dell store
		laptopFactory = getLaptop("Dell");
		laptopFactory.setLaptopName("Dell Inspiron");
		System.out.println(laptopFactory.getLaptopName());

		laptopFactory.setLaptopName("Dell Vostro");
		System.out.println(laptopFactory.getLaptopName());

		// Apple store
		laptopFactory = getLaptop("Macbook");
		laptopFactory.setLaptopName("Macbook Air M1");
		System.out.println(laptopFactory.getLaptopName());

		laptopFactory.setLaptopName("Macbook Pro M1");
		System.out.println(laptopFactory.getLaptopName());
	}

	public static LaptopFactory getLaptop(String laptopType) {
		LaptopFactory laptopFactory;
		switch (laptopType.toUpperCase()) {
		case "ASUS":
			laptopFactory = new Asus();
			break;
		case "DELL":
			laptopFactory = new Dell();
			break;
		case "MACBOOK":
			laptopFactory = new Macbook();
			break;
		default:
			throw new RuntimeException("Laptop type is not support.");
		}
		return laptopFactory;
	}

}
