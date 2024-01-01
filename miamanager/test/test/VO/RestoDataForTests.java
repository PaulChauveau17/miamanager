package test.VO;

import domain.VO.Chief;
import domain.VO.Place;
import domain.VO.Price;
import domain.VO.Resto;
import domain.VO.RestoType;

public abstract class RestoDataForTests {

	protected final static Chief toto = new Chief("Toto Mozzarello"),
			titi = new Chief("Titi Gromino"), tata = new Chief("Tata Alpaga"),
			tatabis = new Chief("Tata Alpaga");

	protected final static Price low = new Price(10),
			average = new Price(15),
			high = new Price(20),
			highbis = new Price(20),
			expensive = new Price(30);

	protected final static Place town = new Place(118, 712),
			sea = new Place(117, 215),
			seabis = new Place(117, 215),
			club = new Place(118, 218);

	protected final static Resto
			diabeteKing = new Resto("diabeteKing", town, titi, low, RestoType.FastFood),
			chillEat = new Resto("chillEat", sea, tata, high, RestoType.Bistro),
			chillEatbis = new Resto("chillEat", seabis, tatabis, highbis, RestoType.Bistro),
			delicioResto = new Resto("delicioResto", town, toto, average, RestoType.Vegetarian),
			pestoResto = new Resto("pestoResto", sea, toto, average, RestoType.Bistro),
			clubLunch = new Resto("clubLunch", club, titi, high, RestoType.FastFood);
}
