package policyexpert.codelab.eventdriven.messagebroker;

import java.util.Map;

public record Message(
        Map<String, String> headers,
        String body
){}
