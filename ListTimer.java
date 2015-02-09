/* Assignment 1, Datastructuren 2015
 * Authors: Alex Khawalid, 10634207
 * 			Philip Bouman, 10668667
 * Date: 09-02-2015
 */

import java.util.*;
import java.lang.*;

public class ListTimer extends CollectionTimer
{
	private List<Integer> list;

	// init list
	public ListTimer(List<Integer> list)
	{
		super();
		this.list = list;
	}

	// init list with seed specified
	public ListTimer(List<Integer> list, long elemGenSeed)
	{
		super(elemGenSeed);
		this.list = list;
	}

	// init list with seed specified
	public ListTimer(List<Integer> list, Long elemGenSeed)
	{
		super(elemGenSeed);
		this.list = list;
	}

	// add element to list
	public void addElement(Integer elem)
	{
		list.add(elem);
	}

	// remove element from list
	public void removeElement()
	{
		// if list is empty throw exception
		if (list.isEmpty() == true)
		{
			throw new IndexOutOfBoundsException();
		}
		else 
		{
			try
			{
				list.remove(0);
			} // if not possible to remove item throw exception
			catch (UnsupportedOperationException exception)
			{
				throw exception;
			}
		}
	}

	// get size of list
	public int getSize() 
	{
		return list.size();
	}

	// return if list is empty
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