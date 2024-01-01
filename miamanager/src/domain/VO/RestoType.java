package domain.VO;

public enum RestoType {

	Vegetarian {
		@Override
		public String toString() {
			return "Vegetarian";
		}
	},
	Bistro {
		@Override
		public String toString() {
			return "Bistro";
		}
	},
	FastFood {
		@Override
		public String toString() {
			return "FastFood";
		}
	}
}
