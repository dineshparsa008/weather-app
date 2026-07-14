package com.lcurve.weather.resource;

import com.lcurve.weather.domain.WeatherResponse;
import com.lcurve.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;

@RestController
@RequestMapping("api/v1/weather")
@Slf4j
public class WeatherResource {


    @Autowired
    private WeatherService weatherService;


    @GetMapping()
    public WeatherResponse getWetherResponse(@RequestParam String city) throws ServiceUnavailableException {
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = weatherService.getResponse(city);
        } catch (Exception exception) {
            log.error("Exception occured while get the weather details: {}", exception.getMessage());
        }
        return weatherResponse;
    }


}