package com.testSSM.test.model;


public class WeatherItems {
	private WeatherInfo [] weatherInfos;
	private String dressAdvise;//穿衣建议  
    private String washCarAdvise;//洗车建议  
    private String coldAdvise;//感冒建议  
    private String sportsAdvise;//运动建议  
    private String ultravioletRaysAdvise;//紫外线建议 
	public WeatherItems() {
		super();
	}
	public WeatherInfo[] getWeatherInfos() {
		return weatherInfos;
	}
	public void setWeatherInfos(WeatherInfo[] weatherInfos) {
		this.weatherInfos = weatherInfos;
	}
	public String getDressAdvise() {
		return dressAdvise;
	}
	public void setDressAdvise(String dressAdvise) {
		this.dressAdvise = dressAdvise;
	}
	public String getWashCarAdvise() {
		return washCarAdvise;
	}
	public void setWashCarAdvise(String washCarAdvise) {
		this.washCarAdvise = washCarAdvise;
	}
	public String getColdAdvise() {
		return coldAdvise;
	}
	public void setColdAdvise(String coldAdvise) {
		this.coldAdvise = coldAdvise;
	}
	public String getSportsAdvise() {
		return sportsAdvise;
	}
	public void setSportsAdvise(String sportsAdvise) {
		this.sportsAdvise = sportsAdvise;
	}
	public String getUltravioletRaysAdvise() {
		return ultravioletRaysAdvise;
	}
	public void setUltravioletRaysAdvise(String ultravioletRaysAdvise) {
		this.ultravioletRaysAdvise = ultravioletRaysAdvise;
	}
	public WeatherItems(WeatherInfo[] weatherInfos, String dressAdvise,
			String washCarAdvise, String coldAdvise, String sportsAdvise,
			String ultravioletRaysAdvise) {
		super();
		this.weatherInfos = weatherInfos;
		this.dressAdvise = dressAdvise;
		this.washCarAdvise = washCarAdvise;
		this.coldAdvise = coldAdvise;
		this.sportsAdvise = sportsAdvise;
		this.ultravioletRaysAdvise = ultravioletRaysAdvise;
	}
	 public void printInf(){  
         
	        System.out.println(dressAdvise);  
	        System.out.println(washCarAdvise);  
	        System.out.println(coldAdvise);  
	        System.out.println(sportsAdvise);  
	        System.out.println(ultravioletRaysAdvise);  
	        for(int i=0;i<weatherInfos.length;i++){  
	            System.out.println(weatherInfos[i]);  
	        }  
	          
	    }  
}
