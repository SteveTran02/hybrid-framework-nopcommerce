package AccessModifierFirst;

public class Laptop {
	public static void main(String[] args) {
		Computer computer = new Computer();

		// Property
		computer.productionName = "Dell";
		System.out.println(computer.productionName);

		// Method
		computer.setProductionName("Asus Gaming");
		System.out.println(computer.productionName);
	}
}
