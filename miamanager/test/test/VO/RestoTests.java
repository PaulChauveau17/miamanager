package test.VO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RestoTests extends RestoDataForTests {

	@Test
	void testEquals() {
		assertEquals(chillEat, chillEatbis);
		assertNotEquals(chillEat, delicioResto);
	}

	@Test
	void testHashCode() {
		assertEquals(chillEat.hashCode(), chillEatbis.hashCode());
		assertNotEquals(chillEat.hashCode(), delicioResto.hashCode());
	}

	@Test
	void testRestoType() {
		assertEquals(chillEat.getType(), chillEatbis.getType());
		assertNotEquals(chillEat.getType(), delicioResto.getType());
	}

}
