package app;

import java.util.ArrayList;
import java.util.Comparator;

import fruits.*;

// example 1:
public class gatherFruits implements Comparator<ArrayList<Fruit>>
// example 2:
//public class gatherFruits implements Comparator<ArrayList<Apple>>
// example 3:
//public class gatherFruits implements Comparator<ArrayList<? extends Apple>>
{
	
	public static void main(String args[])
	{
		new gatherFruits().compareFruits();
	}
	
	private void compareFruits()
	{
		ArrayList<Fruit> fruitList = new ArrayList<>();
		ArrayList<Apple> appleList = new ArrayList<>();
		ArrayList<Orange> orangeList = new ArrayList<>();
		ArrayList<Gala> galaList = new ArrayList<>();
		ArrayList<Fuji> fujiList = new ArrayList<>();

		Apple apple = new Apple(5);
		Orange orange = new Orange(10);
		fruitList.add(apple);
		fruitList.add(orange);
		
		int compare = apple.compareTo(orange);
		System.out.println("Comparing apple to orange: " + compare);

		// using 1st implementation of compare()
		
		// not allowed because ArrayList<Apple> and ArrayList<Orange> is not
		// actually ArrayList<Fruit> (i.e. Fruit superclass has no context of
		// its subclasses
		compare = compare(appleList, orangeList);
		compare = compare(fruitList, appleList);
		
		Gala gala = new Gala(5);
		Fuji fuji = new Fuji(10);
		galaList.add(gala);
		fujiList.add(fuji);

		// now using 2nd implementation of compare() since we shouldn't be
		// comparing apples to oranges anyways! :D
		
		// still not allowed because ArrayList<Gala> and ArrayList<Fuji> is not
		// ArrayList<Apple>!
//		compare = compare(galaList, fujiList);
		System.out.println("Comparing gala to fuji: " + compare);
	}
	
	// example 1:
	public int compare(ArrayList<Fruit> list1, ArrayList<Fruit> list2)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	// example 2:
//	public int compare(ArrayList<Apple> list1, ArrayList<Apple> list2)
//	{
//		// TODO Auto-generated method stub
//		return 0;
//	}

	// example 3:
//	public int compare(ArrayList<? extends Apple> list1, ArrayList<? extends Apple> list2)
//	{
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
