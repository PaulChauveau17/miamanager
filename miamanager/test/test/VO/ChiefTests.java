package test.VO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import domain.VO.Chief;

class ChiefTests {

	private final static Chief toto = new Chief("Toto Mozzarello"), titi = new Chief("Titi Gromino"),
			tata = new Chief("Tata Alpaga"), tatabis = new Chief("Tata Alpaga");

	@Test
	void testEquals() {
		assertNotEquals(toto, titi, "VO should have value equality");
		assertEquals(tata, tatabis, "VO should have value equality");
	}

	@Test
	void testHashCode() {
		assertNotEquals(toto.hashCode(), titi.hashCode(), "VO should have value equality");
		assertEquals(tata.hashCode(), tatabis.hashCode(), "VO should have value equality");
	}

}
