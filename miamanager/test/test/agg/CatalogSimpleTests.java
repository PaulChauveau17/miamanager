package test.agg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appli.manager.InvalidCatOperationException;
import domain.VO.Resto;
import domain.agg.Catalog;

class CatalogSimpleTests extends CatalogDataForTests {

	private final static Catalog tFCat = new Catalog(theFork);

	// Ensure that tests are independents
	@BeforeEach
	protected void catalogFilling() throws InvalidCatOperationException {
		tFCat.addResto(chillEat);
		tFCat.addResto(delicioResto);
	}

	// Ensure that tests are independents
	@AfterEach
	protected void catalogCleaning() throws InvalidCatOperationException {
		tFCat.clearCatalog();
	}

	@Test
	void testCatalogCreation() {
		assertNotNull(theFork, "CatalogID should be created");
		assertNotNull(tFCat, "Catalog should be created");
	}

	@Test
	void testCatalogID() {
		assertEquals(theFork, tFCat.getID(), "CatalogID should be correct");
	}

	@Test
	void testCatalogClean() {
		tFCat.clearCatalog();
		assertTrue(tFCat.getRestoList().isEmpty(), "Resto list should be empty");
	}

	@Test
	void testCatalogRestoList() {
		assertNotNull(tFCat.getRestoList(), "Resto list should be created");
	}

	@Test
	void testCatalogFilling() {
		List<Resto> restoList = tFCat.getRestoList();
		assertTrue(restoList.contains(chillEat), "Resto should be in Catalog");
		assertTrue(restoList.contains(delicioResto), "Resto should be in Catalog");
	}

	@Test
	void testAddRestoInCatalog() throws InvalidCatOperationException {
		tFCat.addResto(diabeteKing);
		tFCat.addResto(clubLunch);
		List<Resto> restoList = tFCat.getRestoList();
		assertTrue(restoList.contains(diabeteKing), "Resto should be in Catalog");
		assertTrue(restoList.contains(clubLunch), "Resto should be in Catalog");
	}

	@Test
	void testRemoveRestoInCatalog() throws InvalidCatOperationException {
		tFCat.removeResto(delicioResto);
		tFCat.removeResto(chillEatbis);
		List<Resto> restoList = tFCat.getRestoList();
		assertTrue(!restoList.contains(delicioResto), "Resto shouldn't be in Catalog");
		assertTrue(!restoList.contains(chillEat), "Resto shouldn't be in Catalog");
	}

}
