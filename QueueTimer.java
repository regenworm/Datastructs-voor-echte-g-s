/* Assignment 1, Datastructuren 2015
 * Authors: Alex Khawalid, 10634207
 * 			Philip Bouman, 10668667
 * Date: 09-02-2015
 */

import java.util.*;
import java.lang.*;

public class QueueTimer extends CollectionTimer
{
	private Queue<Integer> queue;

	// init queuetimer
	public QueueTimer(Queue<Integer> queue)
	{
		super();
		this.queue = queue;

	}

	// init queuetimer with elemgenseed
	public QueueTimer(Queue<Integer> queue, long elemGenSeed)
	{
		super(elemGenSeed);
		this.queue = queue;
	}

	// init queuetimer with unboxed elemgenseed
	public QueueTimer(Queue<Integer> queue, Long elemGenSeed)
	{
		super(elemGenSeed);
		this.queue = queue;
	}

	// add element to queue
	public void addElement(Integer elem)
	{
		queue.add(elem);
	}

	// remove element from queue
	public void removeElement()
	{
		// remove element if queue is not empty
		if (queue.isEmpty() == false)
		{
			queue.remove();
		}
		else 
		{
			throw new NoSuchElementException();
		}
	}

	// get size of queue
	public int getSize()
	{
		return queue.size();
	}

	// check if empty
	public boolean isEmpty()
	{
		if (queue.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}