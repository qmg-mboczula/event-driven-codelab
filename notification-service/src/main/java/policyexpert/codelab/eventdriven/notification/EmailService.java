package policyexpert.codelab.eventdriven.notification;

import static policyexpert.codelab.eventdriven.shared.AnsiColor.ANSI_YELLOW;

public class EmailService {

    public void sentEmail(Email email) {
        ANSI_YELLOW.print("Email sent: " + email);
    }

}
