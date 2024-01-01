package test.VO;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import domain.VO.CatalogID;
import domain.VO.InvalidCatIDException;

class CatalogIDTests {

	private final static String tFName = "theFork";
	private final static int tFNum = 10101010;
	private final static String rouName = "Routard";
	private final static int rouNum = 1212;
	private static CatalogID theFork, routard, routardis;

	@BeforeAll
	static void catalogIDCreation() throws InvalidCatIDException {
		theFork = new CatalogID(tFName, tFNum);
		routard = new CatalogID(rouName, rouNum);
		routardis = new CatalogID(rouName, rouNum);
	}

	@Test
	void testCreation() {
		assertNotNull(theFork, "CatalogID should be created");
		assertNotNull(routard, "CatalogID should be created");
		assertNotNull(routardis, "CatalogID should be created");
	}

	@Test
	void testCreationWithNullName() {
		assertThrows(InvalidCatIDException.class, () -> new CatalogID(null, -1));
		assertThrows(InvalidCatIDException.class, () -> new CatalogID(null, 1001));
	}

	@Test
	void testCreationWithBlankName() {
		assertThrows(InvalidCatIDException.class, () -> new CatalogID("", -1));
		assertThrows(InvalidCatIDException.class, () -> new CatalogID("   ", 1001));
	}

	@Test
	void testCreationWithInvalidNumber() {
		assertThrows(InvalidCatIDException.class, () -> new CatalogID("black cat", -1));
		assertThrows(InvalidCatIDException.class, () -> new CatalogID("black cat", 0));
		assertThrows(InvalidCatIDException.class, () -> new CatalogID("black cat", 999));
	}

	@Test
	void testEquals() {
		assertEquals(routard, routardis, "VO should have value equality");
		assertNotEquals(theFork, routard, "VO should have value equality");
	}

	@Test
	void testHashCode() {
		assertEquals(routard.hashCode(), routardis.hashCode());
		assertNotEquals(routard.hashCode(), theFork.hashCode());
	}

}
