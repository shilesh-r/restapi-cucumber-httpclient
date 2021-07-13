package com.automation.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateUserBase {

    public CreateUserBase() {
    }

    @JsonProperty("name")
    public String name;
    @JsonProperty("job")
    public String job;
}
