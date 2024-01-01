package test.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import appli.manager.CatalogBaseService;
import appli.manager.CatalogService;

class CatSeInitTests {

	protected final static CatalogService se = CatalogService.getInstance();
	protected final static String dCName = "The best default catalog";
	protected final static int dCNum = 1984;

	@Test
	void testExist() {
		assertNotNull(se, "Service should be created");
	}

	@Test
	void testUnique() {
		assertEquals(se, CatalogService.getInstance(), "Service should have an unique instance");
	}

	@Test
	void testDefaultCatID() {
		assertNotNull(CatalogBaseService.getDefaultCatalogID(), "Default catalog id should be created");
		assertEquals(CatalogBaseService.getDefaultCatalogID().getName(), dCName,
				"Default catalog id should have cool name");
		assertEquals(CatalogBaseService.getDefaultCatalogID().getNum(), dCNum,
				"Default catalog id should have cool num");
	}

}
