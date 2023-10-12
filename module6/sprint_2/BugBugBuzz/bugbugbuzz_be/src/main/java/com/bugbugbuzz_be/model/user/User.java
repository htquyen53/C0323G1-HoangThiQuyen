package com.bugbugbuzz_be.model.user;

import com.bugbugbuzz_be.model.app.AppUser;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "date")
    private String birthday;
    private String email;
    private String phoneNumber;
    private String address;
    private String citizenId;
    private String career;
    @Column(columnDefinition = "LONGTEXT")
    private String biography;
    private Long follower;
    private Long following;
    private Boolean isDeleted = false;
    @ManyToOne
    @JoinColumn(name="academic_level_id",referencedColumnName = "id")
    private AcademicLevel academicLevel;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="app_user_id", referencedColumnName = "id")
    private AppUser appUser;
    @OneToMany(mappedBy = "user")
    private Set<Course> courseSet;

    public User() {
    }

    public User(Long id, String name, String birthday, String email, String phoneNumber, String address, String citizenId, String career, String biography, Long follower, Long following, Boolean isDeleted, AcademicLevel academicLevel, AppUser appUser, Set<Course> courseSet) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.citizenId = citizenId;
        this.career = career;
        this.biography = biography;
        this.follower = follower;
        this.following = following;
        this.isDeleted = isDeleted;
        this.academicLevel = academicLevel;
        this.appUser = appUser;
        this.courseSet = courseSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Long getFollower() {
        return follower;
    }

    public void setFollower(Long follower) {
        this.follower = follower;
    }

    public Long getFollowing() {
        return following;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public AcademicLevel getAcademyLevel() {
        return academicLevel;
    }

    public void setAcademyLevel(AcademicLevel academicLevel) {
        this.academicLevel = academicLevel;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }
}
