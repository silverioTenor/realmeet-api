package br.com.sw2you.realmeet.controllers;

import static java.util.concurrent.CompletableFuture.*;

import br.com.sw2you.realmeet.api.facade.RoomsApi;
import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.services.RoomService;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import br.com.sw2you.realmeet.utils.ResponseHttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController implements RoomsApi {
  private final Executor controllerExecutor;
  private final RoomService roomService;

  public RoomController(Executor controllerExecutor, RoomService roomService) {
    this.controllerExecutor = controllerExecutor;
    this.roomService = roomService;
  }

  @Override
  public CompletableFuture<ResponseEntity<RoomDTO>> getRoom(Long id) {
    return supplyAsync(() -> roomService.getRoom(id)).thenApply(ResponseHttpStatus::ok);
  }
}
