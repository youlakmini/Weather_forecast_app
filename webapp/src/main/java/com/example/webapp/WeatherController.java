package com.example.webapp;

import com.example.webapp.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/temperature")
    public Map<String,Object> getTemperature() {
        Double temperature = weatherService.getTemperature();
        Map<String,Object> weatherResponse = new HashMap<>();

        if (temperature != null) {
            weatherResponse.put("city",weatherService.getCity());
            weatherResponse.put("temperature", temperature);
            weatherResponse.put("unit","Celsius");
        }else {
            weatherResponse.put("message","Temperature is null/NA");
        }
        return weatherResponse;
    }
}
