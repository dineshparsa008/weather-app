package com.lcurve.weather.domain;

import lombok.Data;

import java.util.List;

@Data
public class GeoResponse {

    private List<GeoResult> results;

}
