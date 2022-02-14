package br.com.sw2you.realmeet.unit;

import static br.com.sw2you.realmeet.utils.ConstantsTest.*;

import br.com.sw2you.realmeet.core.BaseUnitTest;
import br.com.sw2you.realmeet.domain.entities.Room;
import br.com.sw2you.realmeet.mappers.RoomMapper;
import br.com.sw2you.realmeet.utils.MapperTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomMapperUnitTest extends BaseUnitTest {
  private RoomMapper victim;

  @BeforeEach
  void setupEach() {
    victim = MapperTest.createInstanceRoomMapper();
  }

  @Test
  void testConvertToRoomDto() {
    var room = Room
      .newBuilder()
      .id(DEFAULT_ROOM_ID)
      .name(DEFAULT_ROOM_NAME)
      .seats(DEFAULT_ROOM_SEATS)
      .build();

    var dto = victim.convertToDto(room);

    Assertions.assertEquals(room.getId(), dto.getId());
    Assertions.assertEquals(room.getName(), dto.getName());
    Assertions.assertEquals(room.getSeats(), dto.getSeats());
  }
}
