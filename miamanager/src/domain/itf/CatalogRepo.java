package domain.itf;

import domain.VO.CatalogID;
import domain.agg.Catalog;
import infra.repo.CatNotFoundException;

public interface CatalogRepo {
	public void save(Catalog c);

	public Catalog findByID(CatalogID id) throws CatNotFoundException;

	public boolean checkWithID(CatalogID id);
}
