package com.example.mail_box.repository;

import com.example.mail_box.model.MailBox;

import java.util.List;

public interface IMailBoxRepository {
    MailBox displayAll();
    void update(MailBox mailBox);

}
