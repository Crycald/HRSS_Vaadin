package com.front.hrss.service;

import com.front.hrss.dto.RecruiterHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class RecruiterService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${hrss.endpoint}")
    private String url;

    public void create(RecruiterHolder holder) {
        restTemplate.postForObject(url + "/recruiter/create", (holder), RecruiterHolder.class);
    }
}