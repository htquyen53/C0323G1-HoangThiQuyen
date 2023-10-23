package com.bugbugbuzz_be.model.forum;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "LONGTEXT")
    private String imgPath;
    private Boolean isDeleted;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

}
