package br.com.sw2you.realmeet.integration;

import static br.com.sw2you.realmeet.utils.DataCreatorTest.roomBuilder;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.sw2you.realmeet.api.facade.RoomApi;
import br.com.sw2you.realmeet.core.BaseIntegrationTest;
import br.com.sw2you.realmeet.domain.repositories.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

class RoomApiIntegrationTest extends BaseIntegrationTest {
  @Autowired
  private RoomApi api;

  @Autowired
  private RoomRepository roomRepository;

  @Override
  protected void setupEach() throws Exception {
    setLocalHostBasePath(api.getApiClient(), "/v1");
  }

  @Test
  void testGetRoomSuccess() {
    var room = roomBuilder().build();
    roomRepository.saveAndFlush(room);

    assertNotNull(room.getId());
    assertEquals(1, room.getId());

    var dto = api.getRoom(room.getId());

    assertEquals(room.getId(), dto.getId());
    assertEquals(room.getName(), dto.getName());
    assertEquals(room.getSeats(), dto.getSeats());
  }

  @Test
  void testGetRoomWithIncorrectId() {
    var room = roomBuilder().build();
    roomRepository.saveAndFlush(room);

    assertTrue(room.getActive());
    assertThrows(HttpClientErrorException.NotFound.class, () -> api.getRoom(room.getId()+1));
  }

  @Test
  void testGetRoomInactive() {
    var room = roomBuilder().active(false).build();
    roomRepository.saveAndFlush(room);

    assertFalse(room.getActive());
    assertThrows(HttpClientErrorException.NotFound.class, () -> api.getRoom(room.getId()));
  }
}
