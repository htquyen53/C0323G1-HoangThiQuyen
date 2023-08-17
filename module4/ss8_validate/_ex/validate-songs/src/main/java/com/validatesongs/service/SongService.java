package com.validatesongs.service;

import com.validatesongs.model.Song;
import com.validatesongs.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public Page<Song> findAll(Pageable pageable, String name) {
        return songRepository.findAllByName(pageable,name);
    }

    @Override
    public boolean add(Song song) {
       try {
           songRepository.save(song);
       }catch (Exception e) {
           return false;
       }
        return true;
    }

    @Override
    public boolean update(Song song) {
        try {
            songRepository.save(song);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
