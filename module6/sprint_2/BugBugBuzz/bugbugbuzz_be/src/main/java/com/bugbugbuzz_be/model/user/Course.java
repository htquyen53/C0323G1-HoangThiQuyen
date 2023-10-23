package com.bugbugbuzz_be.model.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    @Column(columnDefinition = "LONGTEXT")
    private String courseImage;
    @Column(columnDefinition = "LONGTEXT")
    private String coursePath;
    private Boolean isDeleted;
//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
}
