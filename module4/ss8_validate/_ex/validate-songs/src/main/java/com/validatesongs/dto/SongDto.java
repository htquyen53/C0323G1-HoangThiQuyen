package com.validatesongs.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private String name;
    private String artist;
    private String genre;

    public SongDto() {
    }

    public SongDto(String name, String artist, String genre) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getName().trim().equals("")) {
            errors.rejectValue("name", null, "Not empty!");
        } else if (songDto.getName().length() > 800) {
            errors.rejectValue("name", null, "Not over 800 characters!");
        }
        if (songDto.getArtist().trim().equals("")) {
            errors.rejectValue("artist", null, "Not empty!");
        } else if (songDto.getArtist().length() > 300) {
            errors.rejectValue("artist", null, "Not over 300 characters!");
        }
        if (songDto.getGenre().trim().equals("")) {
            errors.rejectValue("genre", null, "Not empty!");
        } else if (songDto.getGenre().length() > 1000) {
            errors.rejectValue("genre", null, "Not over 1000 characters!");
        }
    }
}
