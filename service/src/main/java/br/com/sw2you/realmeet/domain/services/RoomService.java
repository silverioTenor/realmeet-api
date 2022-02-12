package br.com.sw2you.realmeet.domain.services;

import br.com.sw2you.realmeet.domain.entities.Room;
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

  public Room findById(Long id) {
    Objects.requireNonNull(id);
    return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
  }
}
