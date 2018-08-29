package com.qa.bae.account;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:8080")
public class AccountController {
    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping("/all")
    public List<Account> getAll() {
        return this.accountRepository.findAll();

    }

    @GetMapping("/{accountNumber}")
    public List<Account> getByAccountNumber(@PathVariable("accountNumber") int accountNumber) {
        return this.accountRepository.findByAccountNumber(accountNumber);
    }

    @PostMapping("/")
    public String insert(@RequestBody Account account) {
        this.accountRepository.insert(account);
        return "{\"message\": \"Success\"}";

    }

    @PutMapping
    public String update(@RequestBody Account account) {
        this.accountRepository.save(account);
        return "{\"message\": \"Success\"}";

    }

    @DeleteMapping("/delete/{accountNumber}")
    public String delete(@PathVariable("accountNumber") int id) {

        List<Account> accounts = this.accountRepository.findByAccountNumber(id);
        this.accountRepository.deleteAll(accounts);

        return "{\"message\": \"Success\"}";

    }

    /*@GetMapping("/{id}")
    public Account getById(@PathVariable("id") String id) {
        //Account account = this.accountRepository.findById(id);
        return null;
    }*/
}
