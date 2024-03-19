package com.tw.thinkcode.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {

  private long input;
  private String calculation;
  private long result;
}
