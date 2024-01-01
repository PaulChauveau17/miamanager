package domain.VO;

import java.util.Objects;

import appli.query.QueryVO;

public class Resto extends QueryVO {

	private final String name;
	private final Place place;
	private final Chief chief;
	private final Price price;
	private final RestoType type;

	public Resto(String name, Place place, Chief chief, Price price, RestoType type) {
		this.name = name;
		this.place = place;
		this.chief = chief;
		this.price = price;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Place getPlace() {
		return place;
	}

	public Chief getChief() {
		return chief;
	}

	public Price getPrice() {
		return price;
	}

	public RestoType getType() {
		return type;
	}

	@Override
	public String toString() {
		return type +" " + name ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, chief, place, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Resto other = (Resto) obj;
		return Objects.equals(name, other.name) && Objects.equals(chief, other.chief)
				&& Objects.equals(place, other.place) && Objects.equals(price, other.price) && type == other.type;
	}

}
