package com.example.test.service;

import com.example.test.dto.IGymRoomDto;
import com.example.test.model.Employee;
import com.example.test.model.GymRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGymRoomService {
    Page<IGymRoomDto> findAllGymRoom(String roomName, String managerName,Pageable pageable);
    boolean deleteGymRoomById(Long id);
    GymRoom findGymRoomById(Long id);
    List<Employee> getManagerList();


}
