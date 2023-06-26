package laptopWithoutFactory;

public class Customer {

	public static void main(String[] args) {
		// Asus store
		Asus asus = new Asus();
		asus.setLaptopName("TUF Gaming");
		System.out.println(asus.getLaptopName());

		asus.setLaptopName("ROG G14");
		System.out.println(asus.getLaptopName());

		// Acer store
		Acer acer = new Acer();
		acer.setLaptopName("Nitro 5");
		System.out.println(acer.getLaptopName());

		// Lenovo store
		Lenovo lenovo = new Lenovo();
		lenovo.setLaptopName("Legion 5");
		System.out.println(lenovo.getLaptopName());
	}
}
