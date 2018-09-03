package com.qa.bae.account;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    //Account findById(String id);

    @Query("{ accountNumber: ?0 }")
    List<Account> findByAccountNumber(int accountNumber);

    @Query("{}")
    List<Account> findAll(Sort sort);

}
