package appli.manager;

import domain.VO.CatalogID;
import domain.VO.InvalidCatIDException;
import domain.VO.Resto;
import domain.agg.Catalog;
import domain.itf.CatalogRepo;
import infra.repo.CatNotFoundException;
import infra.repo.CatRepoInMem;

public abstract class CatalogBaseService { // TODO rerun code formatter (ctrl + maj + f)

	protected static CatalogBaseService instance = null; // static block singleton, not thread safe
	protected static final CatalogID defaultCatID;
	protected static final CatalogRepo repo;
	protected static Catalog cache; // last catalog used

	static {
		try {
			defaultCatID = new CatalogID("The best default catalog", 1984);
		} catch (InvalidCatIDException icide) {
			System.out.println(icide.getMessage());
			throw new ServiceRuntimeException("Failed to create default catalog of CatalogService");
		}
		repo = new CatRepoInMem();
		cache = new Catalog(defaultCatID);
	}

	protected CatalogBaseService() {
	}


	protected boolean catExists(CatalogID id) {
		return (getCurrentCatalogID() == id || repo.checkWithID(id));
	}

	protected Catalog getCat(CatalogID id) throws CatNotFoundException {
		if (cache == null || getCurrentCatalogID() != id) {
			cache = repo.findByID(id);
		}
		System.out.println("Switched to: " + getCurrentCatalogID());
		return cache;
	}

	protected CatalogID buildCatalogID(String name, int num) throws InvalidCatIDException {
		return new CatalogID(name, num);
	}

	// TODO add java doc to following methods
		public void save() {
			repo.save(cache);
		}

	public CatalogID createCatalog(String name, int num) {
		CatalogID id = buildCatalogID(name, num);
		if (catExists(id)) {
			System.out.println(id + " already exists, not creating it again");
		} else {
			repo.save(new Catalog(id));
		}
		return id;
	}

	public void setDefaultCatalog() {
		getCat(defaultCatID); // loads catalog in cache
	}

	public void setCatalog(CatalogID id) throws CatNotFoundException {
		getCat(id); // loads catalog in cache
	}

	public static CatalogID getDefaultCatalogID() {
		return defaultCatID;
	}

	public CatalogID getCurrentCatalogID() {
		return cache.getID();
	}

	public boolean contains(Resto resto) {
		if (resto == null) {
			throw new ServiceRuntimeException("Trying to operate with resto=null in catalog");
		}
		return cache.getRestoList().contains(resto);
	}

	public void add(Resto resto) {
		if (resto == null) {
			throw new ServiceRuntimeException("Trying to add resto=null in catalog");
		}
		try {
			cache.addResto(resto);
		} catch (InvalidCatOperationException icoe) {
			System.out.println(icoe.getMessage());
		}
	}

	public void remove(Resto resto) {
		if (resto == null) {
			throw new ServiceRuntimeException("Trying to remove resto=null from catalog");
		}
		try {
			cache.removeResto(resto);
		} catch (InvalidCatOperationException icoe) {
			System.out.println(icoe.getMessage());
		}
	}

	public void clearCatalog() {
		cache.clearCatalog();
	}
}
