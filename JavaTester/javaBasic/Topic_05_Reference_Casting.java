package javaBasic;

public class Topic_05_Reference_Casting {
	protected String cityName;
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public void showCityName() {
		System.out.println("Student name is " + cityName);
	}
	
	public static void main(String[] args) {
		
		Topic_05_Reference_Casting firstCity = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting secondCity = new Topic_05_Reference_Casting();
		
		firstCity.setCityName("Taipei");
		secondCity.setCityName("Kaohsiung");
		
		// show City Name
		firstCity.showCityName();
		secondCity.showCityName();
		
		
		// ép kiểu
		secondCity = firstCity;
		
		// show City Name
		firstCity.showCityName();
		secondCity.showCityName();
		
		secondCity.setCityName("Tainan");
		
		// show City Name
		firstCity.showCityName();
		secondCity.showCityName();
		
	}
	
}
