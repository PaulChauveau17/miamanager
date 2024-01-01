package test.query;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import appli.manager.CatalogService;
import appli.query.ServiceQueriesRuntimeException;
import domain.VO.Price;

public class SeQueriesExceptionTests {

	private final static CatalogService se = CatalogService.getInstance();

	@Test
	void testfindRestoNearbyNull() {
		assertThrows(ServiceQueriesRuntimeException.class, () -> se.findRestoNearby(null));
	}

	@Test
	void testfindRestoWithNull() {
		assertThrows(ServiceQueriesRuntimeException.class, () -> se.findRestoWith(null));
	}

	@Test
	void testfindRestoBetweenNull() {
		assertThrows(ServiceQueriesRuntimeException.class, () -> se.findRestoBetween(new Price(118), null));
		assertThrows(ServiceQueriesRuntimeException.class, () -> se.findRestoBetween(null, new Price(712)));
		assertThrows(ServiceQueriesRuntimeException.class, () -> se.findRestoBetween(null, null));
	}

	@Test
	void testfindRestoTypeNull() {
		assertThrows(ServiceQueriesRuntimeException.class, () -> se.findRestoType(null));
	}

	@Test
	void testfindRestoNamedNull() {
		assertThrows(ServiceQueriesRuntimeException.class, () -> se.findRestoNamed(null));
	}

}
