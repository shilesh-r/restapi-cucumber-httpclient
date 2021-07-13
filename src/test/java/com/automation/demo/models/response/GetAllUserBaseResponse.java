package com.automation.demo.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetAllUserBaseResponse {
    @JsonProperty("page")
    public Integer page;
    @JsonProperty("per_page")
    public Integer perPage;
    @JsonProperty("total")
    public Integer total;
    @JsonProperty("total_pages")
    public Integer totalPages;
    @JsonProperty("data")
    public List<GetAllUsersData> data = null;
    @JsonProperty("support")
    public GetAllUserResponseSupport support;
}
