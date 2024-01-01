package domain.agg;

import java.util.ArrayList;
import java.util.List;

import appli.manager.InvalidCatOperationException;
import domain.VO.CatalogID;
import domain.VO.Resto;

public class Catalog {

	private final CatalogID id;
	private final List<Resto> restoList = new ArrayList<>(); // TODO A set would reduce problems

	public Catalog(CatalogID id) {
		this.id = id;
	}

	public void addResto(Resto resto) throws InvalidCatOperationException {
		if (resto == null) {
			throw (new InvalidCatOperationException("resto=null is not addable in catalog"));
		}
		if (restoList.contains(resto)) {
			throw (new InvalidCatOperationException(resto + " is already in this catalog, it will not be added again"));
		}
		restoList.add(resto);
	}

	public void removeResto(Resto resto) throws InvalidCatOperationException {
		if (resto == null || !restoList.contains(resto)) {
			throw (new InvalidCatOperationException(resto + " is not in this catalog, it cannot be removed"));
		}
		restoList.remove(resto);
	}

	public void clearCatalog() {
		restoList.clear();
	}

	public CatalogID getID() {
		return id;
	}

	public ArrayList<Resto> getRestoList() {
		return (ArrayList<Resto>) restoList;
	}

	@Override
	public String toString() {
		return "Catalog [" + id + "]";
	}

	// equals and hashCode not overridden here
}
