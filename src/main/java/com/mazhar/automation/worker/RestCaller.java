package com.mazhar.automation.worker;

import com.mazhar.automation.model.Hotel;
import com.mazhar.automation.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class RestCaller {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${hotel.api.key}")
    String hotelApiKey;
    @Value("${hotel.url}")
    String hotelApiUrl;
    @Value("${weather.api.key}")
    String weatherApiKey;


    public synchronized Hotel getHotel(String cityName) {
        String url= hotelApiUrl+cityName;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-rapidapi-host","hotels4.p.rapidapi.com");
        httpHeaders.add("x-rapidapi-key", hotelApiKey);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Hotel> responseEntity =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        httpEntity,
                        Hotel.class
                );

        return responseEntity.getBody();
    }

    public synchronized Weather getWeather(String cityName) {
       try {
           String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + weatherApiKey;
           HttpHeaders httpHeaders = new HttpHeaders();
           httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
           HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

           ResponseEntity<Weather> responseEntity =
                   restTemplate.exchange(
                           url,
                           HttpMethod.GET,
                           httpEntity,
                           Weather.class
                   );

           return responseEntity.getBody();
       }catch (Exception e) {
           return null;
       }
    }



}