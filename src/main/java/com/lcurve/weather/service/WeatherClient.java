package com.lcurve.weather.service;

import com.lcurve.weather.domain.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "weatherClient",
        url = "https://api.open-meteo.com"
)
public interface WeatherClient {

    @GetMapping("/v1/forecast")
    WeatherResponse getWeather(
            @RequestParam("latitude") Double latitude,
            @RequestParam("longitude") Double longitude,
            @RequestParam("current")
            String currentFields
    );


}