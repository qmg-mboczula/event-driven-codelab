package policyexpert.codelab.eventdriven.notification;

public class EmailService {

    public void sentEmail(Email email) {
        System.out.println("Email sent: " + email);
    }

}
