package br.com.sw2you.realmeet.integration;

import static br.com.sw2you.realmeet.utils.DataCreatorTest.roomBuilder;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.sw2you.realmeet.api.facade.RoomApi;
import br.com.sw2you.realmeet.core.BaseIntegrationTest;
import br.com.sw2you.realmeet.domain.repositories.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class RoomApiIntegrationTest extends BaseIntegrationTest {
  @Autowired
  private RoomApi roomApi;

  @Autowired
  private RoomRepository roomRepository;

  @Override
  protected void setupEach() throws Exception {
    setLocalHostBasePath(roomApi.getApiClient(), "/v1");
  }

  @Test
  void testGetRoomSuccess() {
    var room = roomBuilder().build();
    roomRepository.saveAndFlush(room);

    assertNotNull(room.getId());
    assertEquals(1, room.getId());

    var dto = roomApi.getRoom(room.getId());

    assertEquals(room.getId(), dto.getId());
    assertEquals(room.getName(), dto.getName());
    assertEquals(room.getSeats(), dto.getSeats());
  }
}
