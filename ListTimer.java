import java.util.*;
import java.lang.*;

public class ListTimer extends CollectionTimer
{
	private List<Integer> list;

	public ListTimer(List<Integer> list)
	{
		super();
		this.list = list;
	}

	public ListTimer(List<Integer> list, long elemGenSeed)
	{
		super(elemGenSeed);
		this.list = list;
	}

	public ListTimer(List<Integer> list, Long elemGenSeed)
	{


	}

	public void addElement(Integer elem)
	{
		list.add(elem);
	}

	public void removeElement()
	{
		if (list.size() > 0)
		{
			throw new IndexOutOfBoundsException();
		} 
		else 
		{
			try
			{
				list.remove(0);
			}
			catch (UnsupportedOperationException exception)
			{
				throw exception;
			}
		}
	}

	public int getSize() 
	{
		return list.size();
	}

	public boolean isEmpty()
	{
		if (list.size() > 0) 
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}