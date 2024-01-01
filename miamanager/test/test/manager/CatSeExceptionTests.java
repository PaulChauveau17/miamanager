package test.manager;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import appli.manager.CatalogService;
import appli.manager.ServiceRuntimeException;
import infra.repo.CatNotFoundException;

public class CatSeExceptionTests {

	private final static CatalogService se = CatalogService.getInstance();

	@BeforeAll
	protected static void catalogSetup() {
		se.setDefaultCatalog();
	}

	// Ensure that tests are independents
	@AfterEach
	protected void catalogCleaning() {
		se.clearCatalog();
	}

	@Test
	void testcontainsNull() {
		assertThrows(ServiceRuntimeException.class, () -> se.contains(null));
	}

	@Test
	void testAddNull() {
		assertThrows(ServiceRuntimeException.class, () -> se.add(null));
	}

	@Test
	void testRemoveNull() {
		assertThrows(ServiceRuntimeException.class, () -> se.remove(null));
	}

	@Test
	void testSetCatalogNull() {
		assertThrows(CatNotFoundException.class, () -> se.setCatalog(null));
	}

}
