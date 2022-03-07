package br.com.sw2you.realmeet.domain.repositories;

import java.util.Optional;

import br.com.sw2you.realmeet.domain.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByIdAndActive(Long aLong, Boolean aBoolean);
}
