package com.validatesongs.repository;

import com.validatesongs.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISongRepository extends JpaRepository<Song,Integer> {
//    @Query(value = "select * from song where name like :name", nativeQuery = true)
    Page<Song> findAllByName(Pageable pageable, String name);
}
