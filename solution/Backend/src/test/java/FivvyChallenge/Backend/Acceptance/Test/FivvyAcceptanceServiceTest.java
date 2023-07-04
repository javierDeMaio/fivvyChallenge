package FivvyChallenge.Backend.Acceptance.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import FivvyChallenge.Backend.Entity.Acceptance;
import FivvyChallenge.Backend.Repository.AcceptanceRepository;
import FivvyChallenge.Backend.Service.FivvyAcceptanceService;

@RunWith(MockitoJUnitRunner.class)
public class FivvyAcceptanceServiceTest {

	@Mock
	private AcceptanceRepository acceptanceRepository;

	@InjectMocks
	private FivvyAcceptanceService fivvyAcceptanceService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateAcceptance() {
		Date date = new Date();
		Acceptance acceptance = new Acceptance("1", 1l, date);
		Mockito.when(acceptanceRepository.save(Mockito.any())).thenReturn(acceptance);
		Acceptance createdAcceptance = fivvyAcceptanceService.createAcceptance(acceptance);

		Assertions.assertEquals(acceptance, createdAcceptance);
	}

	@Test
	public void testGetAcceptance() {
		Date date = new Date();
		Long userId = 1l;
		Acceptance acceptance1 = new Acceptance("1", 1l, date);
		List<Acceptance> list = new ArrayList<>();
		list.add(acceptance1);
		Mockito.when(acceptanceRepository.save(Mockito.any())).thenReturn(acceptance1);
		Mockito.when(acceptanceRepository.findByUserId(Mockito.any())).thenReturn(list);
		fivvyAcceptanceService.createAcceptance(acceptance1);

		List<Acceptance> result = fivvyAcceptanceService.getAcceptance(userId);

		Assertions.assertEquals(1, result.size());
		Assertions.assertTrue(result.contains(acceptance1));
	}

	@Test
	public void testGetAllAcceptances() {
		Date date = new Date();
		Acceptance acceptance1 = new Acceptance("1", 1l, date);
		List<Acceptance> list = new ArrayList<>();
		list.add(acceptance1);
		Mockito.when(acceptanceRepository.findAll()).thenReturn(list);

		List<Acceptance> result = fivvyAcceptanceService.getAcceptance(null);

		Assertions.assertEquals(1, result.size());
		Assertions.assertTrue(result.contains(acceptance1));
	}
}
