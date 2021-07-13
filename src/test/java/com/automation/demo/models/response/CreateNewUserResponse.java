package com.automation.demo.models.response;

import com.automation.demo.models.CreateUserBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CreateNewUserResponse extends CreateUserBase {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("createdAt")
    public String createdAt;
}
