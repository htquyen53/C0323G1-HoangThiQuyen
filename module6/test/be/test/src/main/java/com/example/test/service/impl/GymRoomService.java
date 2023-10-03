package com.example.test.service.impl;

import com.example.test.dto.IGymRoomDto;
import com.example.test.model.Employee;
import com.example.test.model.GymRoom;
import com.example.test.repository.IGymRoomRepository;
import com.example.test.service.IGymRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymRoomService implements IGymRoomService {
    @Autowired
    private IGymRoomRepository iGymRoomRepository;

    @Override
    public Page<IGymRoomDto> findAllGymRoom(String roomName, String managerName, Pageable pageable) {
        return iGymRoomRepository.findAllRoom(roomName,managerName,pageable);
    }

    @Override
    public GymRoom findGymRoomById(Long id) {
        return iGymRoomRepository.findGymRoomById(id);
    }

    @Override
    public boolean deleteGymRoomById(Long id) {
        try {
            iGymRoomRepository.deleteGymRoomById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Employee> getManagerList() {
        return iGymRoomRepository.getManagerList();
    }
}
