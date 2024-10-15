package policyexpert.codelab.eventdriven.notification;

import static policyexpert.codelab.eventdriven.shared.AnsiColor.ANSI_PURPLE;

public class SmsService {

    private static final String FROM_NUMBER = System.getenv("TWILIO_PHONE_NUMBER");

    SmsService(){
        com.twilio.Twilio.init(
                System.getenv("TWILIO_ACCOUNT_SID"),
                System.getenv("TWILIO_AUTH_TOKEN")
        );
    }


    public void sendSms(Sms sms) {
        createSmsMessage(sms);
        ANSI_PURPLE.print("Sms sent: " + sms);
    }


    private com.twilio.rest.api.v2010.account.Message createSmsMessage(Sms sms){
        return com.twilio.rest.api.v2010.account.Message.creator(
                        new com.twilio.type.PhoneNumber(sms.phoneNumber()),
                        new com.twilio.type.PhoneNumber(FROM_NUMBER),
                        sms.text() + " 📞")
                .create();
    }

}
