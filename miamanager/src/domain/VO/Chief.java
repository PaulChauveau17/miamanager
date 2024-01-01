package domain.VO;

import java.util.Objects;

import appli.query.QueryVO;

public class Chief extends QueryVO {

	private final String fullName;

	public Chief(String s) {
		this.fullName = s;
	}

	public String getFullName() {
		return fullName;
	}

	@Override
	public String toString() {
		return "Chief [fullName=" + fullName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Chief other = (Chief) obj;
		return Objects.equals(fullName, other.fullName);
	}

}
