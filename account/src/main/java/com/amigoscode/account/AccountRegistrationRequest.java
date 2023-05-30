package com.amigoscode.account;

public record AccountRegistrationRequest(
        String firstName,
        String lastName,
        String accountNumber) {
}
