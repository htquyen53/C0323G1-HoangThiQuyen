package com.example.test.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    @Column(columnDefinition = "date")
    private String birthDay;
    private boolean gender;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "gym_room_id", referencedColumnName = "id")
    private GymRoom gymRoom;
    public Employee() {
    }

    public Employee(Long id, String code, String name, String birthDay, boolean gender, Position position, GymRoom gymRoom) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.position = position;
        this.gymRoom = gymRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public GymRoom getGymRoom() {
        return gymRoom;
    }

    public void setGymRoom(GymRoom gymRoom) {
        this.gymRoom = gymRoom;
    }
}
