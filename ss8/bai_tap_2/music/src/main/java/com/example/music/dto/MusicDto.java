package com.example.music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {
    private int id;
    @Size(min = 1, max = 800)
    private String name;
    @Size(min = 1, max = 300)
    private String nameSinger;
    @Size(min = 1, max = 1000)
    private String category;

    public MusicDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if (musicDto.getName().equals("")) {
            errors.rejectValue("name", null, "Not empty");
        } else if (!musicDto.getName().matches("^[^@;,.=+\\\\-]*$")) {
            errors.rejectValue("name", null, "Not match regex");
        }

        if (musicDto.getNameSinger().equals("")) {
            errors.rejectValue("nameSinger", null, "Not empty");
        } else if (!musicDto.getNameSinger().matches("^[^@;,.=+\\\\-]*$")) {
            errors.rejectValue("nameSinger", null, "Not match regex");
        }
        if (musicDto.getCategory().equals("")) {
            errors.rejectValue("category", null, "Not empty");
        } else if (!musicDto.getCategory().matches("^[^!@#$%^&*()_+|\\-=?;:'\".<>\\{\\}\\[\\]\\\\\\`~]*$")) {
            errors.rejectValue("category", null, "Not match regex");
        }
    }
}
