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
public class ReadData {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${hotel.api.key}")
    String hotelApiKey;
    @Value("${hotel.url}")
    String hotelApiUrl;
    @Value("${weather.api.key}")
    String weatherApiKey;


    public Hotel getHotel(String queryParam) {
        String url= hotelApiUrl+queryParam;
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

    public Weather getWeather(String queryParam) {
        String url= "https://api.openweathermap.org/data/2.5/weather?q="+queryParam+"&appid="+weatherApiKey;
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
    }



}
