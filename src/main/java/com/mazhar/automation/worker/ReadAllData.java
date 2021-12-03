package com.mazhar.automation.worker;

import com.mazhar.automation.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReadAllData {
    private final RestCaller restCaller;
    private final DataSource dataSource;


    public List<HotelWeatherModel> startProcess() {
        List<Country> countryList = dataSource.getCountryList();
        if(countryList.isEmpty()){
            dataSource.loadData();
        }
        List<HotelWeatherModel> models = new ArrayList<>();
        for(Country country : countryList) {
            Hotel hotel = restCaller.getHotel(country.getCityName());
            Weather weather = restCaller.getWeather(country.getCityName());
            models.add(new HotelWeatherModel(country.getCountryName(),hotel,weather));
        }
        return models;
    }

    public  List<CountryDataFormat> formatData(List<HotelWeatherModel> models) {
        return models
                .stream()
                .map(data-> {
                    Hotel hotel= data.getHotel();
                    Weather weather = data.getWeather();
                    CountryDataFormat countryDataFormat = new CountryDataFormat();
                    countryDataFormat.setCountryName(data.getCountryName());
                    countryDataFormat.setCityName(hotel.getTerm());
                    List<HotelEntity> hotels = getHotels(hotel);
                    countryDataFormat.setHotelEntityList(hotels);
                    WeatherEntity weatherEntity = generateWeather(weather);
                    countryDataFormat.setWeatherEntity(weatherEntity);
                    return countryDataFormat;
                })
                .collect(Collectors.toList());
    }

    private WeatherEntity generateWeather(Weather weather) {
        if(weather==null){
            return null;
        }
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setDetails(weather.getMain());
        weatherEntity.setSunrise(weather.getSys().getSunrise());
        weatherEntity.setSunset(weather.getSys().getSunset());
        weatherEntity.setTimeZone(weather.getTimezone());
        return weatherEntity;
    }

    private List<HotelEntity> getHotels(Hotel hotel) {
       return hotel.getSuggestions().stream()
                .map(data ->{
                         HotelEntity hotelEntity = new HotelEntity();
                    List<Entity> entities = data.getEntities();
                    if(entities.isEmpty()) {
                        return null;
                    }
                    for(Entity entity: entities) {
                        hotelEntity.setName(entity.getName());
                        hotelEntity.setName(entity.getCaption());
                        hotelEntity.setCompanyName(data.getGroup());
                    }
                    return hotelEntity;
                        }).collect(Collectors.toList());
    }


}
