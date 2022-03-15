package com.qa.project;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.project.domain.Artist;
import com.qa.project.domain.Location;
import com.qa.project.domain.Record;
import com.qa.project.repo.RecordRepo;
import com.qa.project.service.RecordService;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@ActiveProfiles(profiles = "test")

public class VinylRecordsUnitTests {

	@MockBean
	private RecordRepo repo;

	@MockBean
	private ModelMapper mapper;

	@Autowired
	RecordService service;

	@Test
	void createTest() {
		// resources
		Artist testArtist = new Artist();
		testArtist.setArtistId(2);
		testArtist.setArtistName("Test Artist");
		Location testLocation = new Location();
		testLocation.setLocationId(2);
		testLocation.setLocationName("Box #3");
		Record testRecord = new Record(2, testArtist, "Star Trekkin'", "unknown", "Class, pure class",spindleSize.SS_SMALL, testLocation);

		Mockito.when(this.repo.save(Mockito.any(Record.class))).thenReturn(testRecord);

		Record result = this.service.create(testRecord);
		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(testRecord);

		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Record.class));
	}

	@Test
	void readAllTest() {
		// resources
		Artist testArtist1 = new Artist(), testArtist2 = new Artist();
		testArtist1.setArtistId(0);
		testArtist1.setArtistName("Black Lace");
		testArtist2.setArtistId(1);
		testArtist2.setArtistName("Duran Duran");
		Location testLocation1 = new Location(), testLocation2 = new Location();
		testLocation1.setLocationId(0);
		testLocation1.setLocationName("Box #1");
		testLocation2.setLocationId(1);
		testLocation2.setLocationName("Box #2");
		List<Record> expectedResults = List.of(
				new Record(0, testArtist1, "Agadoo", "Agadoo (remix B)", "OK", spindleSize.SS_SMALL, testLocation1),
				new Record(1, testArtist2, "Hungry Like The Wolf", null, "Great", spindleSize.SS_LARGE, testLocation2),
				new Record(2, testArtist2, "Rio", null, "slight scratch", spindleSize.SS_SMALL, testLocation2));

		Mockito.when(this.repo.findAll()).thenReturn(expectedResults);

		List<Record> result = this.service.readAll();

		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(expectedResults);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void updateTest() {
		int id = 1;
		// resources
		Artist testArtist = new Artist();
		testArtist.setArtistId(1);
		testArtist.setArtistName("Duran Duran");
		Location testLocation = new Location();
		testLocation.setLocationId(1);
		testLocation.setLocationName("Box #2");
		Location testNewLocation = new Location();
		testNewLocation.setLocationId(3);
		testNewLocation.setLocationName("Box #3");
		Record testRecord = new Record(1, testArtist, "Hungry Like The Wolf", null, "Great", spindleSize.SS_LARGE,testLocation);
		Record testUpdatedRecord = new Record(1, testArtist, "Hungry Like The Wolf", null, "Great 80's tune!",spindleSize.SS_LARGE, testNewLocation);

		Optional<Record> TEST_OPTIONAL = Optional.of(testRecord);

		Mockito.when(this.repo.findById(id)).thenReturn(TEST_OPTIONAL);
		Mockito.when(this.repo.save(Mockito.any(Record.class))).thenReturn(testUpdatedRecord);

		Record result = this.service.update(id, testUpdatedRecord);

		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(testUpdatedRecord);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(Record.class));
	}
}
