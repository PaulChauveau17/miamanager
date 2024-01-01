package test.manager;

import appli.manager.CatalogService;
import domain.VO.CatalogID;
import test.agg.CatalogDataForTests;

public abstract class CatSeDataForTests extends CatalogDataForTests {

	protected final static CatalogService se = CatalogService.getInstance();
	protected final static String dCName = "The best default catalog";
	protected final static int dCNum = 1984;
	protected final static CatalogID defaultCatID = new CatalogID(dCName, dCNum);

	protected static void routardSetup() {
		se.createCatalog(rouName, rouNum);
		se.setCatalog(routard);
	}

	protected static void fillCurrentCatalogWith5Restos() {
		se.add(chillEat);
		se.add(delicioResto);
		se.add(clubLunch);
		se.add(diabeteKing);
		se.add(pestoResto);
	}

	protected static void fillCurrentCatalogWith3Restos() {
		se.add(chillEatbis);
		se.add(delicioResto);
		se.add(pestoResto);
	}

}
