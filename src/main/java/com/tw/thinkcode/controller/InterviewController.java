package com.tw.thinkcode.controller;

import com.tw.thinkcode.model.ApiResponse;
import com.tw.thinkcode.model.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InterviewController {

  private final RestTemplate restTemplate;
  private final String apiUri;

  public InterviewController(RestTemplate restTemplate, @Value("${api-uri}") String apiUri) {
    this.restTemplate = restTemplate;
    this.apiUri = apiUri;
  }

  @GetMapping("/calculate/{randomNumber}")
  public Result calculate(@PathVariable int randomNumber) {
    ApiResponse resp = restTemplate.getForObject(apiUri, ApiResponse.class, randomNumber);
    return resp.resolve(randomNumber);
  }
}
