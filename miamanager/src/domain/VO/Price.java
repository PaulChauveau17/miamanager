package domain.VO;

import java.util.Objects;

import appli.query.QueryVO;

public class Price extends QueryVO { // TODO implement taxes

	private final Integer total;

	public Price(int i) {
		this.total = i;
	}

	public Integer getTotal() {
		return total;
	}

	public boolean isBetween(Price min, Price max) {
		return (this.getTotal() >= min.getTotal() && this.getTotal() <= max.getTotal());
	}

	@Override
	public String toString() {
		return "Price [total=" + total + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Price other = (Price) obj;
		return Objects.equals(total, other.total);
	}

}
