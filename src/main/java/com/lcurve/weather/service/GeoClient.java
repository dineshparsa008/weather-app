package com.lcurve.weather.service;

import com.lcurve.weather.domain.GeoResponse;
import com.lcurve.weather.domain.GeoResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "geoClient",
        url = "https://geocoding-api.open-meteo.com")
public interface GeoClient {


    @GetMapping("/v1/search")
    GeoResponse getResponse(@RequestParam("name") String name, @RequestParam("count") Integer count);

}
