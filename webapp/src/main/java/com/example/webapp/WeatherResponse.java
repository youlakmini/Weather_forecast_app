package com.example.webapp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.tools.javac.Main;


//This model maps the JSON structure returned by the API
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("main")
    private Main main;

    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }
    public static class Main {
        @JsonProperty("temp")
        private double temp;

        public double getTemp() {
            return temp;
        }
        public void setTemp(double temp) {
            this.temp = temp;
        }
    }
}
