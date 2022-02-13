package br.com.sw2you.realmeet.services;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entities.Room;
import br.com.sw2you.realmeet.domain.repositories.RoomRepository;
import br.com.sw2you.realmeet.exceptions.RoomNotFoundException;
import br.com.sw2you.realmeet.mappers.RoomMapper;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
  private final RoomRepository roomRepository;

  private final RoomMapper roomMapper;

  public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
    this.roomRepository = roomRepository;
    this.roomMapper = roomMapper;
  }

  public RoomDTO getRoom(Long id) {
    Objects.requireNonNull(id);
    Room room = roomRepository
      .findById(id)
      .orElseThrow(() -> new RoomNotFoundException("There is no room with id: " + id));

    return roomMapper.convertToDto(room);
  }
}
