package AccessModifierSecond;

import AccessModifierFirst.Computer;

public class PersonalComputer extends Computer {

	public void showCpuProductName() {
		// Property
		cpuProductName = "Intel";
		System.out.println(cpuProductName);
		// Method
		setCpuProductName("AMD");
		System.out.println(cpuProductName);
	}

}
