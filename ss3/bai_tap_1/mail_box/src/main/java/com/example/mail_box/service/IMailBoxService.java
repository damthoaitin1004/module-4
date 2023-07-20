package com.example.mail_box.service;

import com.example.mail_box.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    MailBox display();
    void update(MailBox mailBox);
}
