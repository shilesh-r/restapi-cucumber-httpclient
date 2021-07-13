package com.automation.demo.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetAllUsersData {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("email")
    public String email;
    @JsonProperty("first_name")
    public String firstName;
    @JsonProperty("last_name")
    public String lastName;
    @JsonProperty("avatar")
    public String avatar;
}
