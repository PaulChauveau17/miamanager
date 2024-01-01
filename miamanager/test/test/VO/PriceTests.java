package test.VO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import domain.VO.Price;

class PriceTests {

	private final static Price low = new Price(10), average = new Price(15), high = new Price(20),
			highbis = new Price(20), expensive = new Price(30);

	@Test
	void testEquals() {
		assertEquals(high, highbis, "VO should have value equality");
		assertNotEquals(low, expensive, "VO should have value equality");
	}

	@Test
	void testHashCode() {
		assertNotEquals(low.hashCode(), average.hashCode(), "VO should have value equality");
		assertEquals(high.hashCode(), highbis.hashCode(), "VO should have value equality");
	}

	@Test
	void testIsBetweenLegit() {
		assertTrue(average.isBetween(low, high));
		assertTrue(!expensive.isBetween(low, high));
	}

	@Test
	void testIsBetweenSwitch() {
		assertTrue(!average.isBetween(expensive, low));
		assertTrue(!low.isBetween(expensive, average));
	}

}
