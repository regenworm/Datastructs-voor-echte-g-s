import java.util.*;
import java.lang.*;

public class QueueTimer extends CollectionTimer
{
	private Queue<Integer> queue;

	public QueueTimer(Queue<Integer> queue)
	{
		super();
		this.queue = queue;

	}

	public QueueTimer(Queue<Integer> queue, long elemGenSeed)
	{
		super(elemGenSeed);
		this.queue = queue;
	}

	public QueueTimer(Queue<Integer> queue, Long elemGenSeed)
	{

	}

	public void addElement(Integer elem)
	{
		queue.add(elem);
	}

	public void removeElement()
	{
		if (queue.size() > 0)
		{
			queue.remove(0);
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
		if (queue.poll() == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}