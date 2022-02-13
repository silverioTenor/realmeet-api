package br.com.sw2you.realmeet.domain.services;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.repositories.RoomRepository;
import br.com.sw2you.realmeet.exceptions.RoomNotFoundException;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
  private final RoomRepository roomRepository;

  public RoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public RoomDTO getRoom(Long id) {
    Objects.requireNonNull(id);
    var room = roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);

    return new RoomDTO().name(room.getName()).id(room.getId()).seats(room.getSeats());
  }
}
