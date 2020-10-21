package utilities;

/**
 * Created on August 21, 2019
 *
 * @author kitty
 * @version 1.1
 * 
 */

import java.util.Comparator;

public final class KittySort
{
	// any guesses on what sorting algorithm this is? :D
	public static <T> void someSort( T[] array, Comparator<? super T> comp )
	{
		while( !isSorted(array, comp) )
		{
			randomize(array);
		}
	}
	
	private static <T> void randomize( T[] array )
	{
		for( int i = 0; i < array.length; i++ )
		{
			swapElements( array, i, (int) Math.floor( Math.random()*i+1 ));
		}
	}
	
	private static <T> void swapElements( T[] array, int i, int j )
	{
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
			
	private static <T> boolean isSorted( T[] array, Comparator<? super T> comp )
	{
		for( int i = 0; i < array.length - 1; i++ )
		{
			if( comp.compare( array[i], array[i+1] ) > 0 )
			{
				return false;
			}
		}
		return true;
	}
}
