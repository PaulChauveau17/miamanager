package ui.cli;

//TODO src should be independent of tests

import test.manager.CatSeDataForTests;

public class FriendlyCLISetup extends CatSeDataForTests {

	protected static void help() {
		System.out.println("\033[4mResto manager\033[0m");
		System.out.println("Call \033[2mhelp(); to display instructions");
		System.out.println("Call examples(); to show some code");
		System.out.println("Call fillCurrentCatalog...(); to start with some data");
		System.out.println("Call 'se' functions to use the resto manager");
		System.out.println(":)");
		System.out.println("When making requests (se.find...), please add on result: ");
		System.out.println("- .displayFirst(); or .displayAll(); to print on console");
		System.out.println("- .getFirst(); and store resto (a QueryVO)");
		System.out.println("- .getAll(); and store resto list");
	}

	protected static void examples() {
		System.out.println("\033[4mExample 1:\033[0m");
		System.out.println("se.findRestoNamed(\"Unicorn resto\").displayFirst();");
		System.out.println("\033[4mExample 2:\033[0m");
		System.out.println("routardSetup();");
		System.out.println("fillCurrentCatalogWith5Restos();");
		System.out.println("se.findRestoBetween(low, average).displayAll();");
		System.out.println("\033[4mExample 3:\033[0m");
		System.out.println("fillCurrentCatalogWith3Restos();");
		System.out.println("QueryVO result = se.findRestoNearby(sea).getFirst();");
		System.out.println("System.out.println(result);");
		System.out.println("\033[4mExample 4:\033[0m");
		System.out.println("CatalogID paulCatID = se.createCatalog(\"Paul's catalog\", 10012001);");
		System.out.println("se.setCatalog(paulCatID);");
		System.out.println("fillCurrentCatalogWith5Restos();");
		System.out.println("Chief nice = new Chief(\"really nice person\");");
		System.out.println("se.add(new Resto(\"Monkey mood\", town, nice, average, RestoType.Vegetarian));");
		System.out.println("List<QueryVO> result = se.findRestoType(RestoType.Vegetarian).getAll();");
		System.out.println("System.out.println(result);");
	}

}
