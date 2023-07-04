package FivvyChallenge.Backend.Acceptance.Test;

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

import FivvyChallenge.Backend.Controller.FivvyAcceptanceController;
import FivvyChallenge.Backend.Entity.Acceptance;
import FivvyChallenge.Backend.Service.FivvyAcceptanceService;

@RunWith(MockitoJUnitRunner.class)
class FivvyAcceptanceControllerTest {

	@Mock
	private FivvyAcceptanceService fivvyAcceptanceService;

	@InjectMocks
	private FivvyAcceptanceController fivvyAcceptanceController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateAcceptance() {

		Date fecha = new Date();
		Acceptance acceptance = new Acceptance("1", 1l, fecha);
		when(fivvyAcceptanceService.createAcceptance(Mockito.any(Acceptance.class))).thenReturn(acceptance);
		ResponseEntity<Acceptance> responseEntity = fivvyAcceptanceController.createAcceptance(acceptance);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(acceptance, responseEntity.getBody());
	}

	@Test
	public void testGetAcceptancesByUserId() {
		Date fecha = new Date();
		Long userId = 1l;
		List<Acceptance> acceptances = new ArrayList<>();
		acceptances.add(new Acceptance("1", 1l,fecha));
		acceptances.add(new Acceptance("2", 1l, fecha));
		when(fivvyAcceptanceService.getAcceptance(userId)).thenReturn(acceptances);

		ResponseEntity<List<Acceptance>> responseEntity = fivvyAcceptanceController.getAcceptancesByUserId(userId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(acceptances, responseEntity.getBody());
	}
}
