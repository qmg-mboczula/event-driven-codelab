package policyexpert.codelab.eventdriven.notification;

import static policyexpert.codelab.eventdriven.shared.AnsiColor.ANSI_PURPLE;

public class SmsService {

    public void sendSms(Sms sms) {
        ANSI_PURPLE.print("Sms sent: " + sms);
    }

}
