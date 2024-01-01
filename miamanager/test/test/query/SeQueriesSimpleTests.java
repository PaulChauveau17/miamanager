package test.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import appli.query.QueryVO;
import domain.VO.RestoType;
import test.manager.CatSeDataForTests;

public class SeQueriesSimpleTests extends CatSeDataForTests {
	// uncomment first line of tests to check them precisely

	@BeforeAll
	protected static void defaultCatalogFilling() {
		se.setDefaultCatalog();
		fillCurrentCatalogWith5Restos();
	}

	@Test
	void testfindAll() {
		se.findAll().displayAll();
		assertEquals(se.findAll().getAll().size(), 5, "Query should find all resto in Catalog");
	}

	@Test
	void testfindRestoNamedPR() {
		// se.findRestoNamed("pestoResto").displayAll();
		assertEquals(se.findRestoNamed("pestoResto").getFirst(), pestoResto, "Query should find resto in Catalog");
	}

	@Test
	void testfindRestoNamedInexistent() {
		// se.findRestoNamed("inexistent").displayAll();
		assertNull(se.findRestoNamed("inexistent").getFirst(), "Query shouldn't find any resto in Catalog");
	}

	@Test
	void testfindRestoNearbyClub() {
		// se.findRestoNearby(club).displayAll();
		List<QueryVO> restos = se.findRestoNearby(club).getAll();
		assertTrue(restos.contains(chillEat) && restos.contains(clubLunch) && restos.contains(pestoResto),
				"Query should find these restos in Catalog");
	}

	@Test
	void testfindRestoNearbyTown() {
		// se.findRestoNearby(town).displayAll();
		List<QueryVO> restos = se.findRestoNearby(town).getAll();
		assertTrue(restos.contains(delicioResto) && restos.contains(diabeteKing),
				"Query should find these restos in Catalog");
	}

	@Test
	void testfindRestoWithTata() {
		// se.findRestoWith(tata).displayAll();
		assertEquals(se.findRestoWith(tata).getFirst(), chillEatbis, "Query should find this resto in Catalog");
	}

	@Test
	void testfindRestoWithToto() {
		// se.findRestoWith(toto).displayAll();
		List<QueryVO> restos = se.findRestoWith(toto).getAll();
		assertTrue(restos.contains(pestoResto) && restos.contains(delicioResto),
				"Query should find these restos in Catalog");
	}

	@Test
	void testfindRestoBetweenLowAndAverage() {
		// se.findRestoBetween(low, average).displayAll();
		List<QueryVO> restos = se.findRestoBetween(low, average).getAll();
		assertTrue(restos.contains(delicioResto) && restos.contains(diabeteKing) && restos.contains(pestoResto),
				"Query should find these restos in Catalog");
	}

	@Test
	void testfindRestoBetweenExpensiveAndAverage() { // args order matters
		// se.findRestoBetween(expensive, average).displayAll();
		List<QueryVO> restos = se.findRestoBetween(expensive, average).getAll();
		assertTrue(restos.isEmpty(), "Query shouldn't find any restos in Catalog");
	}

	@Test
	void testfindRestoTypeVegetarian() {
		// se.findRestoType(RestoType.Vegetarian).displayAll();
		List<QueryVO> restos = se.findRestoType(RestoType.Vegetarian).getAll();
		assertTrue(restos.contains(delicioResto), "Query should find at least this resto in Catalog");
	}
}
