
package com.mazhar.automation.model.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Getter
@Setter
public class Main {

    private Double temp;
    private Double feelsLike;
    private Double tempMin;
    private Double tempMax;
    private Integer pressure;
    private Integer humidity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
