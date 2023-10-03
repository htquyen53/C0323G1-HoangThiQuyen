package com.example.test.controller;

import com.example.test.dto.IGymRoomDto;
import com.example.test.model.Employee;
import com.example.test.model.GymRoom;
import com.example.test.service.IGymRoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/gym_room/api")
public class GymRoomController {
    @Autowired
    private IGymRoomService gymRoomService;
    private Page<IGymRoomDto> gymRooms;

    @GetMapping("/list")
    public ResponseEntity<Page<IGymRoomDto>> getAllGymRoom(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                           @RequestParam(defaultValue = "", required = false) String roomName,
                                                           @RequestParam(defaultValue = "", required = false) String managerName) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<IGymRoomDto> gymRooms = gymRoomService.findAllGymRoom("%" + roomName + "%", "%" + managerName + "%", pageable);
        System.out.println(gymRooms);
        if (gymRooms.getTotalElements() != 0) {
            return ResponseEntity.ok(gymRooms);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id) {
        GymRoom gymRoom = gymRoomService.findGymRoomById(id);
        if (gymRoom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean check = gymRoomService.deleteGymRoomById(id);
        if (check) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/managers")
    public ResponseEntity<List<Employee>> getManagement() {
        List<Employee> managers = gymRoomService.getManagerList();
        if (managers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

}
