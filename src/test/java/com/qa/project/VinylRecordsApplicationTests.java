package com.qa.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "test")

class VinylRecordsApplicationTests {

	@Test
	void contextLoads() {
	}

}
