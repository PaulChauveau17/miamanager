package test.VO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import domain.VO.Place;

class PlaceTests {

	private final static Place town = new Place(118, 712), club = new Place(118, 218), sea = new Place(117, 215),
			seabis = new Place(117, 215);

	@Test
	void testLatAndLon() { // mainly tests args order..
		assertEquals(club.getLat(), 218, "Latitude should be exact");
		assertEquals(club.getLon(), 118, "Longitude should be exact");
	}

	@Test
	void testEquals() {
		assertNotEquals(town, club, "VO should have value equality");
		assertEquals(sea, seabis, "VO should have value equality");
	}

	@Test
	void testHashCode() {
		assertNotEquals(town.hashCode(), sea.hashCode(), "VO should have value equality");
		assertEquals(sea.hashCode(), seabis.hashCode(), "VO should have value equality");
	}

	@Test
	void testIsNear() {
		assertTrue(club.isNear(sea), "These two places should be close from each other");
		assertTrue(sea.isNear(seabis), "These two places should be close from each other");
		assertTrue(!town.isNear(sea), "These two places should be far away");
	}

}
