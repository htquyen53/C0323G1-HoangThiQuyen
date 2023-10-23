package com.bugbugbuzz_be.model.forum;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Visibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isDeleted;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "visibility")
    private Set<Post> postSet;
}
