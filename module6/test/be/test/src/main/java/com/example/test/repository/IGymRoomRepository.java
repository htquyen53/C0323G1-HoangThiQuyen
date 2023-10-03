package com.example.test.repository;

import com.example.test.dto.IGymRoomDto;
import com.example.test.model.Employee;
import com.example.test.model.GymRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IGymRoomRepository extends JpaRepository<GymRoom,Long> {
 @Query(value = " select g.id, g.code, g.name, g.start_date as startDate, g.address, e.name as manager from gym_room g " +
         "join employee e on g.id = e.gym_room_id " +
         "where g.flag_deleted = false and g.name like :roomName and e.name like :managerName and e.position_id = 1 ",
         countQuery = " select count(*) from gym_room g join employee e on g.id = e.gym_room_id where g.flag_deleted = false and g.name like :roomName and e.name like :managerName and e.position_id = 1 ", nativeQuery = true)
    Page<IGymRoomDto> findAllRoom(@Param(value = "roomName") String roomName, @Param(value = "managerName") String managerName, Pageable pageable);
 @Modifying
 @Transactional
 @Query(value = " UPDATE gym_room set flag_deleted = true WHERE id = :id ", nativeQuery = true)
 void deleteGymRoomById(@Param(value = "id") Long id);

 GymRoom findGymRoomById(Long id);


 @Query(value = " select e.id, e.code, e.name, e.birth_day as birthDay, e.gender, e.positionoke  from employee e where e.position_id = 1", nativeQuery = true)
    List<Employee> getManagerList ();
}
