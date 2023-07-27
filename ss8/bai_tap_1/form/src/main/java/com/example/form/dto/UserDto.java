package com.example.form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;

    @Size(min = 3, max = 20)
    private String firstName;
    @Size(min = 3, max = 50)
    private String lastName;

    private String phoneNumber;
    @Min(18)
    private Integer age;
    @Email
    private String email;

    public UserDto(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getFirstName().equals("")){
            errors.rejectValue("firstName",null,"Not empty");
        } else if (!userDto.getFirstName().matches("^[a-zA-Z]*")) {
            errors.rejectValue("firstName",null,"Not match regex");
        }
        if (userDto.getLastName().equals("")) {
            errors.rejectValue("lastName",null,"Not empty");
        } else if (!userDto.getLastName().matches("^[a-zA-Z]*")) {
            errors.rejectValue("lastName",null,"Not match regex");
        }
        if (!userDto.getPhoneNumber().matches("((09|03|07|08|05)+([0-9]{8})\\b)")){
            errors.rejectValue("phoneNumber",null,"not match regex");
        }
    }
}
