package infra.repo;

import java.util.HashMap;
import java.util.Map;

import domain.VO.CatalogID;
import domain.agg.Catalog;
import domain.itf.CatalogRepo;

public class CatRepoInMem implements CatalogRepo {

	private final Map<CatalogID, Catalog> repo = new HashMap<>();

	@Override
	public void save(Catalog cat) {
		this.repo.put(cat.getID(), cat);
	}

	@Override
	public Catalog findByID(CatalogID id) throws CatNotFoundException {
		Catalog cat = repo.get(id);
		if (cat == null) {
			throw(new CatNotFoundException("Failed to get the catalog from repo, "
					+ "please check that catalog identifier is correct"));
		}
		return cat;
	}

	@Override
	public boolean checkWithID(CatalogID id) {
		return repo.containsKey(id);
	}

}
