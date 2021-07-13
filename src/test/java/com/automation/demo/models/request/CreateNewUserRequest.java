package com.automation.demo.models.request;

import com.automation.demo.models.CreateUserBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class CreateNewUserRequest extends CreateUserBase {
    //This Request class will have fields from the base class
}
