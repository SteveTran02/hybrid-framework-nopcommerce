package javaOOP;

public class Topic_06_Getter_Setter {
	// validate data
	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccountMount;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		if (personName.equals(null) || personName.isEmpty() || personName.isBlank()) {
			throw new IllegalArgumentException("Person name is invalid");
		} else {
			this.personName = personName;
		}
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		if (personAge > 16 && personAge < 60) {
			this.personAge = personAge;
		} else {
			throw new IllegalArgumentException("Person age is invalid");
		}
	}

	public int getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(int personPhone) {
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Person number is invalid");
		} else if (String.valueOf(personPhone).length() < 10 || String.valueOf(personPhone).length() > 12) {
			throw new IllegalArgumentException("Person number is invalid");
		} else {
			this.personPhone = personPhone;
		}
	}

	public float getPersonBankAccountMount() {
		return personBankAccountMount;
	}

	public void setPersonBankAccountMount(float personBankAccountMount) {
		if (personBankAccountMount < 0) {
			throw new IllegalArgumentException("Ammount can't be less than 0");
		} else {
			this.personBankAccountMount = personBankAccountMount;
		}
	}

}
