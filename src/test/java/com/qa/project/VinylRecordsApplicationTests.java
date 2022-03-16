package com.qa.project;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "test")

class VinylRecordsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void getLargeTest() {
	String expected ="1.5 inch";
	String actual = spindleSize.SS_LARGE.size();
	assertThat(expected).isEqualTo(actual);
	}
	
	@Test
	void getSmallTest() {
		String expected ="9/32 inch";
		String actual = spindleSize.SS_SMALL.size();
		assertThat(expected).isEqualTo(actual);	
		
	}
}
