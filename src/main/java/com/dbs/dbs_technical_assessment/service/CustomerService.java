package com.dbs.dbs_technical_assessment.service;

import com.dbs.dbs_technical_assessment.model.Customer;
import com.dbs.dbs_technical_assessment.response.MyResponse;
import org.springframework.data.domain.Page;

public interface CustomerService {

    MyResponse<Page<Customer>> getAllCustomersByFirstName(String firstName, int page, int size, String sortBy);
    MyResponse<Page<Customer>> getAllCustomers();
}
