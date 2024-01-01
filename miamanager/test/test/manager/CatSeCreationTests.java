package test.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import domain.VO.CatalogID;
import domain.VO.InvalidCatIDException;

class CatSeCreationTests extends CatSeDataForTests {

	@Test
	void testExist() {
		assertNotNull(se, "Service should be created");
	}

	@Test
	void testCreate() {
		CatalogID id = se.createCatalog(rouName, rouNum);
		se.setCatalog(id);
		assertEquals(id, se.getCurrentCatalogID(), "Service should work with new catalog");
		assertEquals(routard, se.getCurrentCatalogID(), "Service should have correct catalog id");
	}

	@Test
	void testDefaultCatID() {
		final String invalidName = " ";
		final int invalidNum = 12;
		assertThrows(InvalidCatIDException.class, () -> se.createCatalog(invalidName, rouNum));
		assertThrows(InvalidCatIDException.class, () -> se.createCatalog(rouName, invalidNum));
		assertThrows(InvalidCatIDException.class, () -> se.createCatalog(invalidName, invalidNum));
	}

}
