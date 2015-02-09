public class QueueTimer extends CollectionTimer
{
	private java.util.Queue<java.lang.Integer> queue;

	public QueueTimer(java.util.Queue<java.lang.Integer> queue)
	{
		temp = CollectionTimer();
		temp.queue = queue;

	}

	public QueueTimer(java.util.Queue<java.lang.Integer> queue, long elemGenSeed)
	{
		temp = CollectionTimer(elemGenSeed);
		temp.queue = queue;

	}

	public QueueTimer(java.util.Queue<java.lang.Integer> queue, java.lang.Long elemGenSeed)
	{

	}

	public void addElement(java.lang.Integer elem)
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
			throw new java.util.NoSuchElementException();
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