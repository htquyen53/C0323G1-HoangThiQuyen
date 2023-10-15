package com.bugbugbuzz_be.model.user;

import com.bugbugbuzz_be.model.app.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
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
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AppUser appUser;
    @OneToMany(mappedBy = "user")
    private Set<Course> courseSet;
}
