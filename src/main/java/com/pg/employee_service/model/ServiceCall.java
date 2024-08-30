package com.pg.employee_service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCall {

    private final RestTemplate restTemplate;

    @Autowired
    public ServiceCall(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String employeeMicroserviceBaseURL = "http://localhost:8090";

    public Integer getEmployeeId(String mobileNumber) {
        String url = employeeMicroserviceBaseURL + "/api/fetch-id?mobileNumber=" + mobileNumber;
        return restTemplate.getForObject(url, Integer.class);
    }

}
