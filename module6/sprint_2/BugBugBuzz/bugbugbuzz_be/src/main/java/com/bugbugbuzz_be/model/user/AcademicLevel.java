package com.bugbugbuzz_be.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AcademicLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameLevel;
    private Boolean isDeleted;
    @OneToMany(mappedBy = "academicLevel")
    private Set<User> userSet;
}
