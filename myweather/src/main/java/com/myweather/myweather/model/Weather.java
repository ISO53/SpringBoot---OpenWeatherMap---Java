package com.myweather.myweather.model;

/**
 *
 * @author ISO53
 */
public class Weather {

    private String description;
    private String country;
    private String city;
    private float temperature;
    private float minTemperature;
    private float maxTemperature;
    private float humidity;
    private float pressure;
    private float windDegree;
    private float windSpeed;

    public Weather() {
    }

    public Weather(String description, String country, String city, float temperature, float minTemperature, float maxTemperature, float humidity, float pressure, float windDegree, float windSpeed) {
        this.description = description;
        this.country = country;
        this.city = city;
        this.temperature = temperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windDegree = windDegree;
        this.windSpeed = windSpeed;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the temperature
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the minTemperature
     */
    public float getMinTemperature() {
        return minTemperature;
    }

    /**
     * @param minTemperature the minTemperature to set
     */
    public void setMinTemperature(float minTemperature) {
        this.minTemperature = minTemperature;
    }

    /**
     * @return the maxTemperature
     */
    public float getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * @param maxTemperature the maxTemperature to set
     */
    public void setMaxTemperature(float maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    /**
     * @return the humidity
     */
    public float getHumidity() {
        return humidity;
    }

    /**
     * @param humidity the humidity to set
     */
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    /**
     * @return the pressure
     */
    public float getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    /**
     * @return the windDegree
     */
    public float getWindDegree() {
        return windDegree;
    }

    /**
     * @param windDegree the windDegree to set
     */
    public void setWindDegree(float windDegree) {
        this.windDegree = windDegree;
    }

    /**
     * @return the windSpeed
     */
    public float getWindSpeed() {
        return windSpeed;
    }

    /**
     * @param windSpeed the windSpeed to set
     */
    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    

}
