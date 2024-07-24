package com.dbs.dbs_technical_assessment;

import com.dbs.dbs_technical_assessment.model.Customer;
import com.dbs.dbs_technical_assessment.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class DbsTechnicalAssessmentApplication implements CommandLineRunner {

	private final CustomerRepository repository;

    public DbsTechnicalAssessmentApplication(CustomerRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
		SpringApplication.run(DbsTechnicalAssessmentApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("Adding data..");

		Customer c1 = Customer.builder().firstName("adam").age(20).build();
		Customer c2 = Customer.builder().firstName("adam").age(21).build();
		Customer c3 = Customer.builder().firstName("bob").age(44).build();
		Customer c4 = Customer.builder().firstName("cat").age(43).build();
		repository.saveAll(List.of(c1, c2, c3, c4));

		log.info("data added!");
	}
}
