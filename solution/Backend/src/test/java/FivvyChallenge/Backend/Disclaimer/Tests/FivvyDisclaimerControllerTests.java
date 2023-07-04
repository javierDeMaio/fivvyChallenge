package FivvyChallenge.Backend.Disclaimer.Tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import FivvyChallenge.Backend.Controller.FivvyDisclaimerController;
import FivvyChallenge.Backend.Entity.Disclaimer;
import FivvyChallenge.Backend.Service.FivvyDisclaimerService;

@RunWith(MockitoJUnitRunner.class)
public class FivvyDisclaimerControllerTests {

	@Mock
	private FivvyDisclaimerService fivvyDisclaimerService;

	@InjectMocks
	private FivvyDisclaimerController fivvyDisclaimerController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	private List<Disclaimer> disclaimers;

	@Test
	public void testGetDisclaimers() {
		Date date = new Date();
		String text = "Disclaimer";
		List<Disclaimer> disclaimers = new ArrayList<>();
		disclaimers.add(new Disclaimer("1", "Disclaimer 1", "hello", 1l, date, date));
		disclaimers.add(new Disclaimer("2", "Disclaimer 2", "bye bye", 1l, date, date));

		when(fivvyDisclaimerService.getDisclaimers(text)).thenReturn(disclaimers);

		ResponseEntity<List<Disclaimer>> responseEntity = fivvyDisclaimerController.getDisclaimers(text);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(disclaimers, responseEntity.getBody());
	}

	@Test
	public void testCreateDisclaimer() {
		Date date = new Date();
		Disclaimer disclaimer = new Disclaimer("1", "Disclaimer text", "hello", 1l, date, date);

		when(fivvyDisclaimerService.createDisclaimer(Mockito.any(Disclaimer.class))).thenReturn(disclaimer);
		ResponseEntity<Disclaimer> responseEntity = fivvyDisclaimerController.createDisclaimer(disclaimer);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(disclaimer, responseEntity.getBody());
	}

	@Test
	public void testUpdateDisclaimer() {

		Date date = new Date();
		String disclaimerId = "1";
		Disclaimer updatedDisclaimer = new Disclaimer("1", "Updated disclaimer text", "Hello", 2l, date, date);
		when(fivvyDisclaimerService.updateDisclaimer(disclaimerId, updatedDisclaimer)).thenReturn(updatedDisclaimer);

		ResponseEntity<Disclaimer> responseEntity = fivvyDisclaimerController.updateDisclaimer(disclaimerId,
				updatedDisclaimer);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(updatedDisclaimer, responseEntity.getBody());
	}

	@Test
	public void testDeleteDisclaimer() {

		String disclaimerId = "1";

		when(fivvyDisclaimerService.deleteDisclaimer(disclaimerId)).thenReturn(true);

		ResponseEntity<Void> responseEntity = fivvyDisclaimerController.deleteDisclaimer(disclaimerId);
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
	}
}
