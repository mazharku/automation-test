
package com.mazhar.automation.model.responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mazhar.automation.model.responses.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Suggestion {

    private String group;
    private List<Entity> entities = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
