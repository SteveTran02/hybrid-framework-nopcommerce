package AccessModifierFirst;

public class Computer {

	// Property
	String productionName; // Default
	protected String cpuProductName;
	// Method

	void setProductionName(String computerProduction) {
		this.productionName = computerProduction;
	}

	protected void setCpuProductName(String cpuProductName) {
		this.cpuProductName = cpuProductName;
	}

	public static void main(String[] args) {
		Computer computer = new Computer();

		// Property
		computer.cpuProductName = "Intel";
		System.out.println(computer.cpuProductName);

		// Method
		computer.setCpuProductName("AMD");
		System.out.println(computer.cpuProductName);
	}

}
