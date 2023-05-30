package com.amigoscode.account;

import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public void registerAccount(AccountRegistrationRequest request) {
    	Account account = Account.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .accountNumber(request.accountNumber())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        accountRepository.saveAndFlush(account);
        
        /*
        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Amigoscode...",
                        customer.getFirstName())
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );*/

    }

	public Optional<Account> getAccount(Integer id) {
		return accountRepository.findById(id);
	}
}
