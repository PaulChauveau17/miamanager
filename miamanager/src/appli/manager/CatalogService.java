package appli.manager; // TODO move in src package in miamanager

import appli.query.QueriesManager;
import appli.query.QueryResult;
import appli.query.QueryVO;
import appli.query.ServiceQueriesRuntimeException;
import domain.VO.Chief;
import domain.VO.Place;
import domain.VO.Price;
import domain.VO.RestoType;

public class CatalogService extends CatalogBaseService {

	private static final QueriesManager queMan;

	static {
		instance = new CatalogService();
		queMan = new QueriesManager();
		instance.save();
	}

	public static CatalogService getInstance() {
		if (instance == null) {
			instance = new CatalogService();
		}
		return (CatalogService) instance;
	}

	public QueryResult findAll()
	{
		return queMan.findAll(cache);
	}

	private CatalogService() {
		super();
	}

	private static void checkQVO(QueryVO vo) {
		if (vo == null) {
			throw new ServiceQueriesRuntimeException("Query attempt with null");
		}
	}

	public QueryResult findRestoNearby(Place place) {
		checkQVO(place);
		return queMan.findRestoNearby(cache, place);
	}

	public QueryResult findRestoWith(Chief chief) {
		checkQVO(chief);
		return queMan.findRestoWith(cache, chief);
	}

	public QueryResult findRestoBetween(Price min, Price max) {
		checkQVO(min);
		checkQVO(max);
		return queMan.findRestoBetween(cache, min, max);
	}

	public QueryResult findRestoType(RestoType type) {
		if (type == null) {
			throw new ServiceQueriesRuntimeException("Query attempt with null");
		}
		return queMan.findRestoType(cache, type);
	}

	public QueryResult findRestoNamed(String name) {
		if (name == null) {
			throw new ServiceQueriesRuntimeException("Query attempt with null");
		}
		return queMan.findRestoNamed(cache, name);
	}
}
