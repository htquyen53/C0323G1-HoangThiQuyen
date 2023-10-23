package com.bugbugbuzz_be.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AcademicLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameLevel;
    private Boolean isDeleted;
    @JsonBackReference
    @OneToMany(mappedBy = "academicLevel")
    private Set<User> userSet;
}
