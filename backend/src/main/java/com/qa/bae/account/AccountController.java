package com.qa.bae.account;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/all")
    public List<Account> getAll() {
        return this.accountRepository.findAll();

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/{accountNumber}")
    public List<Account> getByAccountNumber(@PathVariable("accountNumber") int accountNumber) {
        return this.accountRepository.findByAccountNumber(accountNumber);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/")
    public void insert(@RequestBody Account account) {
        this.accountRepository.insert(account);
    }

    @PutMapping
    public void update(@RequestBody Account account) {
        this.accountRepository.save(account);
    }

    @DeleteMapping("/delete/{accountNumber}")
    public void delete(@PathVariable("accountNumber") int id) {

        List<Account> accounts = this.accountRepository.findByAccountNumber(id);
        this.accountRepository.deleteAll(accounts);

    }

    /*@GetMapping("/{id}")
    public Account getById(@PathVariable("id") String id) {
        //Account account = this.accountRepository.findById(id);
        return null;
    }*/
}
