package appli.query;

import java.util.List;

public class QueryResult {

	private final String message;
	private final List<QueryVO> VOList;

	public QueryResult(String msg, List<QueryVO> objs) {
		message = msg;
		VOList = objs;
	}

	public List<QueryVO> getAll() {
		return VOList;
	}

	public QueryVO getFirst() {
		if (VOList.isEmpty())
		 {
			return null; // TODO return something else when empty?
		}
		return VOList.get(0);
	}

	public void printMessage() {
		System.out.println(message);
	}

	private boolean printIfEmpty() {
		if (VOList.isEmpty()) {
			System.out.println("No result");
			return true;
		}
		return false;
	}

	public void displayAll() {
		printMessage();
		if (!printIfEmpty()) {
			for (Object obj : VOList) {
				System.out.println(obj);
			}
		}
	}

	public void displayFirst() {
		printMessage();
		if (!printIfEmpty()) {
			System.out.println(VOList.get(0));
		}
	}

}
