package com.tw.thinkcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tw.thinkcode.model.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiResponseTest {

  @Test
  void apiResponseModel() {
    var response = getApiResponse();
    assertEquals(response.getA(), 5);
  }

  ApiResponse getApiResponse() {
    var response = new ApiResponse();
    response.setA(5);
    response.setB(5);
    response.setOp("+");
    return response;
  }
}
