package javaOOP.abstraction;

public interface IAnimal {

	// public static final
	int BANK_BALANCE = 1000;

	// public abstract
	String getName();

	void setName(String animalName);

	public abstract String getAddress();

	public abstract String setAddress(String addressName);

}
