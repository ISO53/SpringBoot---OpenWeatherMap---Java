package com.myweather.myweather.model;

/**
 *
 * @author ISO53
 */
public class AirQuality {
    
    private int airQuality;
    private float CO;
    private float NO;
    private float NO2;
    private float O3;
    private float SO2;
    private float pm2_5;
    private float pm10;
    private float NH3;

    public AirQuality() {
    }

    public AirQuality(int airQuality, float CO, float NO, float NO2, float O3, float SO2, float pm2_5, float pm10, float NH3) {
        this.airQuality = airQuality;
        this.CO = CO;
        this.NO = NO;
        this.NO2 = NO2;
        this.O3 = O3;
        this.SO2 = SO2;
        this.pm2_5 = pm2_5;
        this.pm10 = pm10;
        this.NH3 = NH3;
    }

    /**
     * @return the airQuality
     */
    public int getAirQuality() {
        return airQuality;
    }

    /**
     * @param airQuality the airQuality to set
     */
    public void setAirQuality(int airQuality) {
        this.airQuality = airQuality;
    }

    /**
     * @return the CO
     */
    public float getCO() {
        return CO;
    }

    /**
     * @param CO the CO to set
     */
    public void setCO(float CO) {
        this.CO = CO;
    }

    /**
     * @return the NO
     */
    public float getNO() {
        return NO;
    }

    /**
     * @param NO the NO to set
     */
    public void setNO(float NO) {
        this.NO = NO;
    }

    /**
     * @return the NO2
     */
    public float getNO2() {
        return NO2;
    }

    /**
     * @param NO2 the NO2 to set
     */
    public void setNO2(float NO2) {
        this.NO2 = NO2;
    }

    /**
     * @return the O3
     */
    public float getO3() {
        return O3;
    }

    /**
     * @param O3 the O3 to set
     */
    public void setO3(float O3) {
        this.O3 = O3;
    }

    /**
     * @return the SO2
     */
    public float getSO2() {
        return SO2;
    }

    /**
     * @param SO2 the SO2 to set
     */
    public void setSO2(float SO2) {
        this.SO2 = SO2;
    }

    /**
     * @return the pm2_5
     */
    public float getPm2_5() {
        return pm2_5;
    }

    /**
     * @param pm2_5 the pm2_5 to set
     */
    public void setPm2_5(float pm2_5) {
        this.pm2_5 = pm2_5;
    }

    /**
     * @return the pm10
     */
    public float getPm10() {
        return pm10;
    }

    /**
     * @param pm10 the pm10 to set
     */
    public void setPm10(float pm10) {
        this.pm10 = pm10;
    }

    /**
     * @return the NH3
     */
    public float getNH3() {
        return NH3;
    }

    /**
     * @param NH3 the NH3 to set
     */
    public void setNH3(float NH3) {
        this.NH3 = NH3;
    }
    
    
}
