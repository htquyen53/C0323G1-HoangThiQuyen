package com.example.test.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(20)", unique = true)
    private String code;
    @ManyToOne
    @JoinColumn(name = "gym_room_id", referencedColumnName = "id")
    private GymRoom gymRoom;
    private String name;
    @Column(name="citizen_id", unique = true)
    private String citizenId;
    @Column(columnDefinition = "date")
    private String birthDay;
    private Boolean gender;
    @Column(columnDefinition = "date")
    private String startDay;
    @Column(columnDefinition = "date")
    private String endDay;

    public Customer() {
    }

    public Customer(Long id, String code, GymRoom gymRoom, String name, String citizenId, String birthDay, Boolean gender, String startDay, String endDay) {
        this.id = id;
        this.code = code;
        this.gymRoom = gymRoom;
        this.name = name;
        this.citizenId = citizenId;
        this.birthDay = birthDay;
        this.gender = gender;
        this.startDay = startDay;
        this.endDay = endDay;
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

    public GymRoom getGymRoom() {
        return gymRoom;
    }

    public void setGymRoom(GymRoom gymRoom) {
        this.gymRoom = gymRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }
}
