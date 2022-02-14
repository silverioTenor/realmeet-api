package br.com.sw2you.realmeet.utils;

import br.com.sw2you.realmeet.mappers.RoomMapper;
import org.mapstruct.factory.Mappers;

public final class MapperTest {

  private MapperTest() {}

  public static RoomMapper createInstanceRoomMapper() {
    return Mappers.getMapper(RoomMapper.class);
  }
}
