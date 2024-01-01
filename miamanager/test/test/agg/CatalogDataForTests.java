package test.agg;

import domain.VO.CatalogID;
import test.VO.RestoDataForTests;

public abstract class CatalogDataForTests extends RestoDataForTests {

	protected final static String tFName = "theFork";
	protected final static int tFNum = 10101010;
	protected final static String rouName = "Routard";
	protected final static int rouNum = 1212;
	protected final static CatalogID theFork = new CatalogID(tFName, tFNum);
	protected final static CatalogID routard = new CatalogID(rouName, rouNum);

}
