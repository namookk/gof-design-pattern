package com.gofdesignpattern.facade.before;

import com.gofdesignpattern.facade.after.EmailMessage;
import com.gofdesignpattern.facade.after.EmailSender;
import com.gofdesignpattern.facade.after.EmailSettings;
import org.apache.logging.log4j.message.Message;

import java.util.Properties;

public class Client {
    public static void main(String[] args) {
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("127.0.0.1");

        EmailSender emailSender = new EmailSender(emailSettings);
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("namookk");
        emailMessage.setTo("namookk");
        emailMessage.setSubject("오징어게임");
        emailMessage.setText("밖은 더 지옥이더라고..");
        emailSender.sendEmail(emailMessage);
    }
}
