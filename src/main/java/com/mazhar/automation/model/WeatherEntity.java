package com.mazhar.automation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WeatherEntity {
   private Main details;
   private long sunrise;
   private long sunset;
   private int timeZone;
}
