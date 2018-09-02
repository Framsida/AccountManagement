package com.qa.bae.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
    private AccountRepository accountRepository;

    @Autowired
    public DbSeeder(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Account jordan = new Account(
                "Jordan",
                "Venters",
                "JV@gmail.com",
                1001
        );

        //Clear the Accounts
        //this.accountRepository.deleteAll();

        //Add the new accounts
        this.accountRepository.save(jordan);
    }

}
