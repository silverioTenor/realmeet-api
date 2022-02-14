package br.com.sw2you.realmeet.utils;

import static br.com.sw2you.realmeet.utils.ConstantsTest.DEFAULT_ROOM_NAME;
import static br.com.sw2you.realmeet.utils.ConstantsTest.DEFAULT_ROOM_SEATS;

import br.com.sw2you.realmeet.domain.entities.Room;

public class DataCreatorTest {

  private DataCreatorTest() {}

  public static Room.RoomBuilder roomBuilder() {
    return Room.newBuilder().name(DEFAULT_ROOM_NAME).seats(DEFAULT_ROOM_SEATS);
  }
}
