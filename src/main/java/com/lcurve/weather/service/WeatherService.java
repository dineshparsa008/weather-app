package com.lcurve.weather.service;

import com.lcurve.weather.domain.GeoResponse;
import com.lcurve.weather.domain.GeoResult;
import com.lcurve.weather.domain.WeatherResponse;
import feign.FeignException;
import feign.RetryableException;
import feign.slf4j.Slf4jLogger;
import io.micrometer.common.util.StringUtils;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.naming.ServiceUnavailableException;
import java.net.ConnectException;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    private final GeoClient geoClient;

    public WeatherResponse getResponse(String place) throws ServiceUnavailableException {
        WeatherResponse weatherResponse = null;
        try {
            if (StringUtils.isNotBlank(place)) {
                GeoResponse response = geoClient.getResponse(place, 1);
                if (response != null && !CollectionUtils.isEmpty(response.getResults())) {
                    GeoResult geoResult = response.getResults().get(0);
                    if (geoResult != null) {
                        weatherResponse = weatherClient.getWeather(geoResult.getLatitude(), geoResult.getLongitude(), "temperature_2m,relative_humidity_2m,weather_code");
                    }
                }
            }
        } catch (FeignException.NotFound e) {
            log.error("Not found Exception");
        } catch (RetryableException retryableException) {
            log.error("Weather Service unavailable", retryableException);
            throw new ServiceUnavailableException(
                    "Customer service is temporarily unavailable");
        } catch (FeignException e) {
            // handle other HTTP errors
        }
        return weatherResponse;
    }
}
