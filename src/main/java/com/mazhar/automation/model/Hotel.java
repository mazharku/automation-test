
package com.mazhar.automation.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hotel {

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
