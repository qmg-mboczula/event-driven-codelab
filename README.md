# Event-Driven Codelab

## Introduction
This codelab's purpose is to show how two services can communicate in an event-driven, asynchronous way through using an event queue mechanism

## Description
As an e-commerce application we want to send our customers notifications whenever they purchased with us. Therefore we need to make two of our services: `payment-service` and `notification-service` communicate in order to do that task

`payment-service` publishes an event in the form of a message to the `message-broker` queue instance every time a payment has been registered. It publishes an `email` field as a part of its header and a string as a part of its body.

## Task
In order to complete our objective we need to:
1. Register `PaymentMessageConsumer` in the `notification-service` subproject as a subscriber to the right instance of the `MessageQueue`
2. Implement `PaymentMessageConsumer.consumeMessage` to send an email through the `EmailService` to the email given in the `email` header of the message and a body given in the body of the message.
3. (additional) Have an SMS sent along with the email through the `SmsService`

Before implementing the solution please familiarise yourself with the `Main.main` method containing all the 'glue' logic and the classes themselves. Good luck!