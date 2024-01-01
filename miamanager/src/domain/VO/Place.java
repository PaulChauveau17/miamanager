package domain.VO;

import java.util.Objects;

import appli.query.QueryVO;

public class Place extends QueryVO {
	private final Integer lon;
	private final Integer lat;

	public Place(int lon, int lat) {
		this.lon = lon;
		this.lat = lat;
	}

	public Integer getLon() {
		return lon;
	}

	public Integer getLat() {
		return lat;
	}

	public boolean isNear(Place p) {
		if (Math.abs(this.getLat() - p.getLat()) > 10 || Math.abs(this.getLon() - p.getLon()) > 10) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Place [lon=" + lon + ", lat=" + lat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(lat, lon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Place other = (Place) obj;
		return Objects.equals(lat, other.lat) && Objects.equals(lon, other.lon);
	}

}
