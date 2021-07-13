package com.automation.demo.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetAllUserResponseSupport {
    @JsonProperty("url")
    public String url;
    @JsonProperty("text")
    public String text;
}
