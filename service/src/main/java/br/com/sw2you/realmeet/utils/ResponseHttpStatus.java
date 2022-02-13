package br.com.sw2you.realmeet.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ResponseHttpStatus {

  private ResponseHttpStatus() {}

  public static <T> ResponseEntity<T> ok(T body) {
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
