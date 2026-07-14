package com.lcurve.weather.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherResponse {


    private double latitude;

    private double longitude;

    @JsonProperty("generationtime_ms")
    private double genertaionTime;

    @JsonProperty("utc_offset_seconds")
    private int utcOffset;

    private String timezone;

    private String timeZoneAbbreviation;

    private double elevation;

    @JsonProperty("current_units")
    private CurrentUnit currentUnit;

    @JsonProperty("current")
    private CurrentUnit current;

}
