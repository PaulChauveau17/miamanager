package domain.VO;

import java.util.Objects;

public class CatalogID {

	private static final int minNumID = 1000;

	private final Integer num;
	private final String name;

	public CatalogID(String name, int num) throws InvalidCatIDException {
		if (name == null || name.isBlank()) {
			throw (new InvalidCatIDException("CatalogID should have a name"));
		}
		if (num <= CatalogID.minNumID) {
			throw (new InvalidCatIDException("CatalogID should be greater than " + CatalogID.minNumID));
		}
		this.num = num;
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " (" + num +")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		CatalogID other = (CatalogID) obj;
		return Objects.equals(name, other.name) && Objects.equals(num, other.num);
	}

}
