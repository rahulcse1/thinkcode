package com.tw.thinkcode.model;

import static java.util.Map.entry;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

  interface OpFn {
    long call(long a, long b);
  }

  private static final Map<String, OpFn> OPS =
      Map.ofEntries(
          entry("+", (a, b) -> a + b), entry("-", (a, b) -> a - b), entry("*", (a, b) -> a * b));

  public Result resolve(long input) {
    var res = OPS.getOrDefault(op, invalidOP(op)).call(a, b);
    return new Result(input, String.format("%d %s %d = %d", a, op, b, res), res);
  }

  private static OpFn invalidOP(String op) {
    return (a, b) -> {
      throw new IllegalArgumentException(
          String.format("'%s' is not a valid operation. Valid operations: %s", op, OPS.keySet()));
    };
  }

  private long a;
  private long b;
  private String op;
}
