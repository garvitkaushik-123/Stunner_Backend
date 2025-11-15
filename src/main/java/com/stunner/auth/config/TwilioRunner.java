package com.stunner.auth.config;

import com.twilio.Twilio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TwilioRunner implements CommandLineRunner {

    private final TwilioConfig twilioConfig;

    public TwilioRunner(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
    }
}