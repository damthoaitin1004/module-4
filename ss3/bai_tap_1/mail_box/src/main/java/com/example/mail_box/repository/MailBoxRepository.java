package com.example.mail_box.repository;

import com.example.mail_box.model.MailBox;
import org.springframework.stereotype.Repository;

@Repository
public class MailBoxRepository implements IMailBoxRepository {

    private static MailBox mailBox = new MailBox("vietnamese",15,true,"Joker");

    @Override
    public MailBox displayAll() {
        return mailBox;
    }

    public void update(MailBox mailBoxUpdate) {
        mailBox = mailBoxUpdate;
    }
}


