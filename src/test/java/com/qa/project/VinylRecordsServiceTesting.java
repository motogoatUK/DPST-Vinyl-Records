package com.qa.project;

import java.util.List;
import org.springframework.http.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.project.domain.Artist;
import com.qa.project.domain.Location;
import com.qa.project.domain.Record;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@ActiveProfiles(profiles = "test")
@AutoConfigureMockMvc

public class VinylRecordsServiceTesting {

//	@MockBean
//	private RecordService  service;

//	@Autowired
//	private ModelMapper mapper;
	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper jsonifier;

//	@BeforeEach
//	public void setUp() {
//		Artist testArtist = new Artist();
//		testArtist.setArtistName("Test Artist");
//		Location testLocation = new Location();
//		testLocation.setLocationName("Box #1");
//		
//	}
	private final String URL = "http://localhost:8080/record/";
	
	

	@Test
	public void testCreate() throws Exception {
		Artist testArtist = new Artist();
		testArtist.setArtistId(2);
		testArtist.setArtistName("Test Artist");
		Location testLocation = new Location();
		testLocation.setLocationId(2);
		testLocation.setLocationName("Box #3");

		Record testRecord = new Record(2, testArtist, "Star Trekkin'", "unknown", "Class, pure class",
				spindleSize.SS_SMALL, testLocation);
		// expectedResponse = json {"Id":1, {"artist_id":2,"artist_name":"Test Artist"},"sideA":"Star Trekkin\'",
		// 							"sideB":"unknown","observation":"Class, pure class","spindle":"SS_SMALL",
		//							{"location_id":2,"location_name":"Box #3"}
		String expectedResponse = jsonifier.writeValueAsString(testRecord);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, URL + "create")
				.contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(testRecord))
				.accept(MediaType.APPLICATION_JSON);

		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(expectedResponse);

		// when(service.create(testRecord)).thenReturn(testRecord);
		// assertThat(controller.createRecord(testRecord)).isEqualTo(expectedResponse);
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}
	@Test
	void testReadAll() throws Exception {
		// resources
		Artist testArtist1 = new Artist(), testArtist2 = new Artist();
		testArtist1.setArtistId(0);	testArtist1.setArtistName("Black Lace");
		testArtist2.setArtistId(1);	testArtist2.setArtistName("Duran Duran");
		Location testLocation1 = new Location(), testLocation2 = new Location();
		testLocation1.setLocationId(0); testLocation1.setLocationName("Box #1");
		testLocation2.setLocationId(1); testLocation2.setLocationName("Box #2");
		List<Record> expectedResult = List.of(
				new Record(1, testArtist1, "Agadoo", "Agadoo (remix B)" , "OK", spindleSize.SS_SMALL, testLocation1), 
				new Record(2, testArtist2, "Hungry Like The Wolf", null, "Great", spindleSize.SS_LARGE, testLocation2));
				
		
		// set up request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, URL + "list");
		
		// set up expectations
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
		
		// perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

}
