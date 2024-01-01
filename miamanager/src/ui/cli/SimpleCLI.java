package ui.cli;

import domain.VO.CatalogID;
import domain.VO.Chief;
import domain.VO.Resto;
import domain.VO.RestoType;

@SuppressWarnings("unused")
public class SimpleCLI extends FriendlyCLISetup {

//	 tips: 'ctrl + maj + :' to (un)comment, 'ctrl + space' to show suggestions
	public static void main(String[] args) { // used by Anna and Mael
//		help();
//		examples();
//		prompt here
		CatalogID paulCatID = se.createCatalog("Paul's catalog", 10012001);
		se.setCatalog(paulCatID);
		fillCurrentCatalogWith5Restos();
		Chief nice = new Chief("really nice person");
		se.add(new Resto("Monkey mood", town, nice, average, RestoType.Vegetarian));
		se.findRestoType(RestoType.Vegetarian).displayAll();
	}
}
