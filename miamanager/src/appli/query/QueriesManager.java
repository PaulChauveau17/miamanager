package appli.query;

import java.util.ArrayList;
import java.util.List;

import domain.VO.Chief;
import domain.VO.Place;
import domain.VO.Price;
import domain.VO.Resto;
import domain.VO.RestoType;
import domain.agg.Catalog;

public class QueriesManager {
	// TODO add nested queries:
	// run first request, put result in a tmp catalog, run second request..

	public QueryResult findRestoNearby(Catalog cat, Place place) {
		List<QueryVO> restos = new ArrayList<>();
		for (Resto r : cat.getRestoList()) {
			if (place.isNear(r.getPlace())) {
				restos.add(r);
			}
		}
		return new QueryResult("Resto(s) near " + place + " from " + cat, restos);
	}

	public QueryResult findRestoWith(Catalog cat, Chief chief) {
		List<QueryVO> restos = new ArrayList<>();
		for (Resto r : cat.getRestoList()) {
			if (chief.equals(r.getChief())) {
				restos.add(r);
			}
		}
		return new QueryResult("Resto(s) where " + chief + " is working from " + cat, restos);
	}

	public QueryResult findRestoBetween(Catalog cat, Price min, Price max) {
		String msg = "Resto(s) from " + min + " to " + max + " from " + cat;
		List<QueryVO> restos = new ArrayList<>();
		if (min.getTotal() > max.getTotal()) {
			msg = msg + "\nwarning: min > max";
		}
		for (Resto r : cat.getRestoList()) {
			if (r.getPrice().isBetween(min, max)) {
				restos.add(r);
			}
		}
		return new QueryResult(msg, restos);
	}

	public QueryResult findRestoType(Catalog cat, RestoType type) {
		List<QueryVO> restos = new ArrayList<>();
		for (Resto r : cat.getRestoList()) {
			if (type.equals(r.getType())) {
				restos.add(r);
			}
		}
		return new QueryResult("Resto(s) with " + type + " type from " + cat, restos);
	}

	public QueryResult findRestoNamed(Catalog cat, String name) {
		List<QueryVO> restos = new ArrayList<>();
		for (Resto r : cat.getRestoList()) {
			if (name.equals(r.getName())) { // TODO implement regular expression
				restos.add(r);
			}
		}
		return new QueryResult("Resto(s) named " + name + " from " + cat, restos);
	}

	public QueryResult findAll(Catalog cat) {
		List<QueryVO> restos = new ArrayList<>();
		for (Resto r : cat.getRestoList()) {
			restos.add(r);
		}
		return new QueryResult("All resto(s) from " + cat, restos);
	}
}
