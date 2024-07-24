package com.dbs.dbs_technical_assessment.controller;

import com.dbs.dbs_technical_assessment.model.Customer;
import com.dbs.dbs_technical_assessment.response.MyResponse;
import com.dbs.dbs_technical_assessment.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RestController
@Validated
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(description = "Retrieve customers by first name. you can sort by age or firstname",
            tags = "Retrieve customers by first name")
    @GetMapping("getCustomers")
    public ResponseEntity<MyResponse<Page<Customer>>> searchCustomersByName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "age") String sortBy,
            @RequestParam(defaultValue = "adam") String firstName,
            @RequestParam(defaultValue = "ASC") String ascDesc) {
        return ResponseEntity.ok(customerService.getAllCustomersByFirstName(firstName, page, size, sortBy,ascDesc));
    }
    @GetMapping("getAllCustomers")
    public ResponseEntity<MyResponse<Page<Customer>>> getAllustomers(
            ) {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}
