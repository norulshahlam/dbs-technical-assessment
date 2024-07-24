package com.dbs.dbs_technical_assessment.impl;

import com.dbs.dbs_technical_assessment.model.Customer;
import com.dbs.dbs_technical_assessment.repository.CustomerRepository;
import com.dbs.dbs_technical_assessment.response.MyResponse;
import com.dbs.dbs_technical_assessment.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.PageRequest.of;
import static org.springframework.data.domain.Sort.by;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public MyResponse<Page<Customer>> getAllCustomersByFirstName(String firstName, int page, int size, String sortBy, String ascDesc) {

        Pageable pageRequest = of(page, size).withSort(by(Sort.Direction.valueOf(ascDesc),sortBy));
        Page<Customer> all = repository.findByFirstName(firstName, pageRequest);
        return MyResponse.successResponse(all);
    }

    @Override
    public MyResponse<Page<Customer>> getAllCustomers() {
        List<Customer> all = repository.findAll();
        return MyResponse.successResponse(all);
    }
}
