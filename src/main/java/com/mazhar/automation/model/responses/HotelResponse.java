
package com.mazhar.automation.model.responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelResponse {

    private String term;
    private Integer moresuggestions;
    private Object autoSuggestInstance;
    private String trackingID;
    private Boolean misspellingfallback;
    private List<Suggestion> suggestions = new ArrayList<>();
    private Boolean geocodeFallback;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
