package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
public class User {
    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;
    @Min(18)
    private int ages;

    public User() {
    }

    public User(@NotEmpty @Size(min = 2, max = 30) String name,  @Min(18) int ages) {
        this.name = name;
        this.ages = ages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAges() {
        return ages;
    }

    public void setAges(int ages) {
        this.ages = ages;
    }
}
