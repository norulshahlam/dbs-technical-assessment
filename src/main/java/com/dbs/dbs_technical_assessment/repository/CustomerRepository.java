package com.dbs.dbs_technical_assessment.repository;

import com.dbs.dbs_technical_assessment.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findByFirstName(String firstName, Pageable pageable);
}
