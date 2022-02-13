package br.com.sw2you.realmeet.exceptions;

public class RoomNotFoundException extends RuntimeException {

  public RoomNotFoundException(String message) {
    super(message);
  }
}
