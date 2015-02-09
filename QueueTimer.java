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

	public void addElement(Integer elem)
	{
		queue.add(elem);
	}

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

	public int getSize()
	{
		return queue.size();
	}

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