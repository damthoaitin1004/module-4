package com.example.mail_box.service;

import com.example.mail_box.model.MailBox;
import com.example.mail_box.repository.IMailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MailBoxService implements IMailBoxService {
    @Autowired
    private  IMailBoxRepository mailBoxRepository;

    @Override
    public MailBox display() {
        return mailBoxRepository.displayAll();
    }

    @Override
    public void update(MailBox mailBox) {
        mailBoxRepository.update(mailBox);
    }
}
