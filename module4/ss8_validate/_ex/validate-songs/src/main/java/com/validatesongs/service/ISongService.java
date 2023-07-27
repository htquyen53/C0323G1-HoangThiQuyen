package com.validatesongs.service;

import com.validatesongs.model.Song;

public interface ISongService {
    boolean add(Song song);
    boolean update(Song song);
}
