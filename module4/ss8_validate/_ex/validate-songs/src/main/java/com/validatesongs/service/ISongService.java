package com.validatesongs.service;

import com.validatesongs.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    Page<Song> findAll(Pageable pageable, String name);
    boolean add(Song song);
    boolean update(Song song);
}
