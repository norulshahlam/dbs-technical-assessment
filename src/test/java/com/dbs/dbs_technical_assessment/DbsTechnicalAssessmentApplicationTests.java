package com.dbs.dbs_technical_assessment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DbsTechnicalAssessmentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void filterEvenNumberAndDisplayOnlyOddNumber() {
		List<Integer> allNumber = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> onlyOddNumber = allNumber.stream()
				.filter(i -> i % 2 != 0)
				.collect(Collectors.toList());
		System.out.println(allNumber);
		System.out.println(onlyOddNumber);
	}

}
