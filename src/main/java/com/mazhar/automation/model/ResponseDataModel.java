package com.mazhar.automation.model;

import com.mazhar.automation.model.responses.HotelResponse;
import com.mazhar.automation.model.responses.WeatherResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseDataModel {
    private String countryName;
    private HotelResponse hotelResponse;
    private WeatherResponse weatherResponse;
}
