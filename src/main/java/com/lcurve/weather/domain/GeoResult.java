package com.lcurve.weather.domain;


import lombok.Data;

@Data
public class GeoResult {

    private String name;

    private Double latitude;

    private Double longitude;

    private String country;


}
