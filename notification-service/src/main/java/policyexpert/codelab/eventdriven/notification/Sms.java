package policyexpert.codelab.eventdriven.notification;

public record Sms (
        String phoneNumber,
        String text
) {}