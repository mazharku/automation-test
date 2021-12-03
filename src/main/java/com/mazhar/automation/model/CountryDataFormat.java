package com.mazhar.automation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryDataFormat {
    String CountryName;
    String CityName;
    private List<HotelEntity> hotelEntityList;
    private WeatherEntity weatherEntity;
}
