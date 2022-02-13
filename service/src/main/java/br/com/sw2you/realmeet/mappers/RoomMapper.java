package br.com.sw2you.realmeet.mappers;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entities.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {

  public abstract RoomDTO convertToDto(Room room);
}
