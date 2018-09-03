package com.qa.bae.account;


import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Sort sort = new Sort(Sort.Direction.ASC, "accountNumber");
        return this.accountRepository.findAll(sort);

    }

    @GetMapping("/{accountNumber}")
    public List<Account> getByAccountNumber(@PathVariable("accountNumber") int accountNumber) {
        return this.accountRepository.findByAccountNumber(accountNumber);
    }

    @GetMapping("/id/{id}")
    public Optional<Account> getByID(@PathVariable("id") String id) {
        return this.accountRepository.findById(id);
    }

    @PostMapping("/")
    public String insert(@RequestBody Account account) {
        this.accountRepository.insert(account);
        return "{\"message\": \"Success\"}";

    }

    @PutMapping("/")
    public String update(@RequestBody Account account) {
        this.accountRepository.save(account);
        return "{\"message\": \"Success\"}";

    }

    @DeleteMapping("/delete/{accountNumber}")
    public String delete(@PathVariable("accountNumber") String id) {

        this.accountRepository.deleteById(id);

        return "{\"message\": \"Success\"}";

    }
}
