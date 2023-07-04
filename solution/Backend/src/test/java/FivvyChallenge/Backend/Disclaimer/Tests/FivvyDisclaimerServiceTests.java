package FivvyChallenge.Backend.Disclaimer.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import FivvyChallenge.Backend.Entity.Disclaimer;
import FivvyChallenge.Backend.Exception.NotFoundException;
import FivvyChallenge.Backend.Repository.DisclaimerRepository;
import FivvyChallenge.Backend.Service.FivvyDisclaimerService;

@RunWith(MockitoJUnitRunner.class)
public class FivvyDisclaimerServiceTests {

	@InjectMocks
	private FivvyDisclaimerService fivvyDisclaimerService;

	@Mock
	private DisclaimerRepository disclaimerRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetDisclaimersWithoutText() {
		Date date = new Date();
		Disclaimer disclaimer1 = new Disclaimer("1", "Example Disclaimer 1", "hello", 1l, date, date);
		Disclaimer disclaimer2 = new Disclaimer("2", "Example Disclaimer 2", "hello", 1l, date, date);
		Mockito.when(disclaimerRepository.save(Mockito.any())).thenReturn(disclaimer1);
		disclaimerRepository.save(disclaimer1);
		List<Disclaimer> list = new ArrayList<>();
		list.add(disclaimer1);
		Mockito.when(disclaimerRepository.findAll()).thenReturn(list);
		List<Disclaimer> result = fivvyDisclaimerService.getDisclaimers(null);

		assertEquals(1, result.size());
		assertTrue(result.contains(disclaimer1));

		Mockito.when(disclaimerRepository.save(Mockito.any())).thenReturn(disclaimer2);
		disclaimerRepository.save(disclaimer2);
		List<Disclaimer> list2 = new ArrayList<>();
		list2.add(disclaimer2);
		Mockito.when(disclaimerRepository.findAll()).thenReturn(list2);
		List<Disclaimer> result2 = fivvyDisclaimerService.getDisclaimers(null);

		assertEquals(1, result2.size());
		assertTrue(result2.contains(disclaimer2));
	}

	@Test
	public void testGetDisclaimersWithNonexistentText() {
		String text = "nonexistent";
		assertThrows(NotFoundException.class, () -> fivvyDisclaimerService.getDisclaimers(text));
	}

	@Test
	public void testCreateDisclaimerService() {
		Date date = new Date();
		Disclaimer disclaimer = new Disclaimer("1", "Example Disclaimer", "hello", 1l, date, date);
		Mockito.when(disclaimerRepository.save(Mockito.any())).thenReturn(disclaimer);
		Disclaimer result = fivvyDisclaimerService.createDisclaimer(disclaimer);

		assertNotNull(result);
		assertEquals(disclaimer, result);
		assertNotNull(result.getCreateAt());
	}

	@Test
	public void testUpdateDisclaimerService() {
		Date date = new Date();
		String id = "1";
		Disclaimer existingDisclaimer = new Disclaimer(id, "Existing Disclaimer", "hello", 1l, date, date);
		Disclaimer updatedDisclaimer = new Disclaimer(id, "Updated Disclaimer", "hello", 1l, date, date);
		List<Disclaimer> list = new ArrayList<>();
		list.add(existingDisclaimer);
		Mockito.when(disclaimerRepository.findById(Mockito.anyString())).thenReturn(list);
		Mockito.when(disclaimerRepository.save(Mockito.any())).thenReturn(updatedDisclaimer);
		fivvyDisclaimerService.updateDisclaimer(id, existingDisclaimer);
		Disclaimer result2 = fivvyDisclaimerService.updateDisclaimer(id, updatedDisclaimer);

		assertNotNull(result2);
		assertEquals(updatedDisclaimer, result2);
		assertNotNull(result2.getCreateAt());
		assertNotNull(result2.getUpdateAt());
		assertEquals(id, result2.getId());
	}

	@Test
	public void testUpdateDisclaimerWithNonexistentId() {
		Date date = new Date();
		String id = "1";
		Disclaimer updatedDisclaimer = new Disclaimer(id, "Updated Disclaimer", "hello", 1l, date, date);

		assertThrows(NotFoundException.class, () -> fivvyDisclaimerService.updateDisclaimer(id, updatedDisclaimer));
	}

	@Test
	public void testDeleteDisclaimerService() {
		Date date = new Date();
		String id = "1";
		Disclaimer disclaimer = new Disclaimer(id, "Example Disclaimer", "hello", 1l, date, date);
		List<Disclaimer> list = new ArrayList<>();
		list.add(disclaimer);
		Mockito.when(disclaimerRepository.findById(Mockito.anyString())).thenReturn(list);

		boolean result = fivvyDisclaimerService.deleteDisclaimer(id);

		assertTrue(result);
	}

	@Test
	public void testDeleteDisclaimerWithNonexistentId() {
		String id = "1";

		assertThrows(NotFoundException.class, () -> fivvyDisclaimerService.deleteDisclaimer(id));
	}

}
