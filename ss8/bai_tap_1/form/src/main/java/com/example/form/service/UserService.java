package com.example.form.service;

import com.example.form.model.User;
import com.example.form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public void add(User user) {
        iUserRepository.save(user);
    }
}
