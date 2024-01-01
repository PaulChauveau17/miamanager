package test.agg;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appli.manager.InvalidCatOperationException;
import domain.agg.Catalog;

class CatalogExceptionTests extends CatalogDataForTests {

	private final static Catalog tFCat = new Catalog(theFork);
	private final static Catalog rouCat = new Catalog(routard);


	// Ensure that tests are independents
	@BeforeEach
	private void catalogFilling() throws InvalidCatOperationException {
		tFCat.addResto(chillEat);
		tFCat.addResto(delicioResto);
	}

	// Ensure that tests are independents
	@AfterEach
	private void catalogCleaning() {
		tFCat.clearCatalog();
	}

	@Test
	void testAddRestoAlreadyIn() {
		assertThrows(InvalidCatOperationException.class, () -> tFCat.addResto(delicioResto));
	}

	@Test
	void testAddRestoWithCloneIn() {
		assertThrows(InvalidCatOperationException.class, () -> tFCat.addResto(chillEatbis));
	}

	@Test
	void testRemoveAgain() throws InvalidCatOperationException {
		tFCat.removeResto(chillEat);
		assertThrows(InvalidCatOperationException.class, () -> tFCat.removeResto(chillEat));
		assertThrows(InvalidCatOperationException.class, () -> tFCat.removeResto(chillEatbis));
	}

	@Test
	void testRemoveAbsent() {
		assertTrue(!tFCat.getRestoList().contains(clubLunch), "Resto shouldn't be in Catalog");
		assertThrows(InvalidCatOperationException.class, () -> tFCat.removeResto(clubLunch));
	}

	@Test
	void testAddNull() throws InvalidCatOperationException {
		assertThrows(InvalidCatOperationException.class, () -> rouCat.addResto(null));
	}

	@Test
	void testRemoveNull() throws InvalidCatOperationException {
		assertThrows(InvalidCatOperationException.class, () -> rouCat.removeResto(null));
	}
}
