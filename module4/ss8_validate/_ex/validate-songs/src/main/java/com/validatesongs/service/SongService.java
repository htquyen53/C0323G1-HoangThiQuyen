package com.validatesongs.service;

import com.validatesongs.model.Song;
import com.validatesongs.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

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
