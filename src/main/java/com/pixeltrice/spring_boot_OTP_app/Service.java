package com.pixeltrice.spring_boot_OTP_app;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
public class Service {

    private final String ACCOUNT_SID = System.getenv("ACf245c70f17c0c6ce60175df06b476d63");

    private final String AUTH_TOKEN =  System.getenv("656b7c43a13c68882c4868531b515bf2");

    private final String FROM_NUMBER = System.getenv("+12567871552");

    public void send(SmsPojo sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}
