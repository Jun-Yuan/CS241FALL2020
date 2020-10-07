import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GenericList<E>
{

	private ArrayList<E> list;


	public GenericList()
	{
		list = new ArrayList<E>( );
	}

	public void addToFront(E e)
	{
		list.add( e );
	}

	public void remove(E e)
	{

		for ( int i = list.size()-1; i >= 0; i-- )
		{
			if ( list.get(i).equals( e ) )
			{
				list.remove(i);

				return;
			}
		}
		throw new NoSuchElementException();

	}


	public int size()
	{
		return( list.size() );
	}


	public void clear()
	{
		list.clear();
	}


	public Iterator iterator()
	{
		return new Iterator();
	}


	public class Iterator
	{

		int current;


		public Iterator()
		{
			current = list.size()-1;
		}

		public boolean hasNext()
		{
			return ( current >= 0 );
		}


		public E next()
		{
			if ( current < 0 )
				throw new NoSuchElementException();

			current--;
			return list.get( current + 1 );
		}
	}
}
