package com.amigoscode.account;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public void registerAccount(@RequestBody AccountRegistrationRequest accountRegistrationRequest) {
        log.info("new account registration {}", accountRegistrationRequest);
        accountService.registerAccount(accountRegistrationRequest);
    }
    
    @GetMapping("/{id}")
    public Optional<Account> getAccount(@PathVariable Integer id) {
    	log.info("retrieving account with ID number {}", id);
    	return accountService.getAccount(id);
    }
    
}
