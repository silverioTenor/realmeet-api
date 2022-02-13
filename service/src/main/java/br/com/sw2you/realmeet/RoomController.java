package br.com.sw2you.realmeet;

import static java.util.concurrent.CompletableFuture.*;

import br.com.sw2you.realmeet.api.facade.RoomsApi;
import br.com.sw2you.realmeet.api.model.RoomDTO;
import java.util.concurrent.CompletableFuture;

import br.com.sw2you.realmeet.domain.services.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController implements RoomsApi {

  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @Override
  public CompletableFuture<ResponseEntity<RoomDTO>> getRoom(Long id) {
    return supplyAsync(() -> ResponseEntity.ok(roomService.getRoom(id)));
  }
}
