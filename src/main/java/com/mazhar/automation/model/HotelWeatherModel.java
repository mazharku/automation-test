package com.mazhar.automation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HotelWeatherModel {
    private String countryName;
    private Hotel hotel;
    private Weather weather;
}
