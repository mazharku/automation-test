package com.mazhar.automation.model;

import com.mazhar.automation.model.responses.Main;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Weather {
   private Main details;
   private long sunrise;
   private long sunset;
   private int timeZone;
}
