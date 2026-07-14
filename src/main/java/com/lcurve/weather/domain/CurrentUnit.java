package com.lcurve.weather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class CurrentUnit {

    private String time;

    private String interval;

    @JsonProperty("temperature_2m")
    private String temperature;

    @JsonProperty("relative_humidity_2m")
    private String humidity;

    @JsonProperty("weather_code")
    private String code;


}
