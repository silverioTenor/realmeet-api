package br.com.sw2you.realmeet.unit;

import static br.com.sw2you.realmeet.utils.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.sw2you.realmeet.core.BaseUnitTest;
import br.com.sw2you.realmeet.domain.entities.Room;
import br.com.sw2you.realmeet.domain.repositories.RoomRepository;
import br.com.sw2you.realmeet.exceptions.RoomNotFoundException;
import br.com.sw2you.realmeet.mappers.RoomMapper;
import br.com.sw2you.realmeet.services.RoomService;
import br.com.sw2you.realmeet.utils.DataCreatorTest;
import br.com.sw2you.realmeet.utils.MapperTest;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class RoomServiceUnitTest extends BaseUnitTest {
  private RoomService victim;

  @Mock
  private RoomRepository roomRepository;

  @BeforeEach
  void setupEach() {
    victim = new RoomService(roomRepository, MapperTest.createInstanceRoomMapper());
  }

  @Test
  void testGetRoomSuccess() {
    var room = DataCreatorTest.roomBuilder().id(DEFAULT_ROOM_ID).build();
    Mockito.when(roomRepository.findByIdAndActive(DEFAULT_ROOM_ID, true)).thenReturn(Optional.of(room));

    var dto = victim.getRoom(DEFAULT_ROOM_ID);

    assertEquals(room.getId(), dto.getId());
    assertEquals(room.getName(), dto.getName());
    assertEquals(room.getSeats(), dto.getSeats());
  }

  @Test
  void testGetRoomNotFound() {
    Mockito.when(roomRepository.findByIdAndActive(DEFAULT_ROOM_ID, true)).thenReturn(Optional.empty());
    assertThrows(RoomNotFoundException.class, () -> victim.getRoom(DEFAULT_ROOM_ID));
  }
}
