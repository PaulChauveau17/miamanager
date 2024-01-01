package test.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TODO try to make these tests quiet
public class CatSeSimpleTests extends CatSeDataForTests {

	@BeforeAll
	protected static void routardCreation() {
		routardSetup();
	}

	// Ensure that tests are independents
	@BeforeEach
	protected void catalogFilling() {
		fillCurrentCatalogWith3Restos();
	}

	// Ensure that tests are independents
	@AfterEach
	protected void catalogCleaning() {
		se.clearCatalog();
	}

	@Test
	void testAddRestoAlreadyIn() {
		se.add(delicioResto); // should not crash
		assertEquals(se.findRestoNamed("delicioResto").getAll().size(), 1,
				"Query should find only 1 resto in Catalog");

	}

	@Test
	void testAddRestoWithCloneIn() {
		se.add(chillEat); // should not crash
		assertEquals(se.findRestoNamed("chillEat").getAll().size(), 1,
				"Query should find only 1 resto in Catalog");
	}

	@Test
	void testRemoveAgain() {
		assertTrue(se.contains(chillEat), "Resto should be in Catalog");
		se.remove(chillEat);
		se.remove(chillEat); // should not crash
		assertTrue(!se.contains(diabeteKing), "Resto shouldn't be in Catalog");
	}

	@Test
	void testRemoveAbsent() {
		assertTrue(!se.contains(diabeteKing), "Resto shouldn't be in Catalog");
		se.remove(diabeteKing); // should not crash
	}

}
