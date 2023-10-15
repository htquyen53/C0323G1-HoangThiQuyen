package com.bugbugbuzz_be.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
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
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
}
