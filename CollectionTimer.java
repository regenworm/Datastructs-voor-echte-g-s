import java.util.*;
import java.lang.*;


public abstract class CollectionTimer extends Object
{
	public static final int[] DEFAULT_MUTATIONS = {10000, -10000};
	private Random elemGen;

	// init
	public CollectionTimer()
	{
		elemGen = new Random(0);
	}

	// init with seed
	public CollectionTimer(long elemGenSeed)
	{
		elemGen = new Random(elemGenSeed);
	}

	public abstract void addElement(Integer elem);

	public abstract void removeElement();

	public abstract int getSize();

	public abstract boolean isEmpty();

	public void insert(int amount)
	{
		// add elements
		for (int i = 0; i < amount; i++)
		{
			addElement(elemGen.nextInt());
		}

	}

	public boolean extract(int amount)
	{
		// try to remove elements and return bool
		try
		{
			for (int i = amount; i < 0; i++)
			{
				removeElement();
			}
		} // if not possible return false 
		catch (RuntimeException e) 
		{
			return false;
		}
		
		return true;
	}

	// time default operations
	public long time()
	{
		return time(DEFAULT_MUTATIONS);
	}

	// time specified operations
	public long time(int[] mutations)
	{
		// log current time
		long start = System.currentTimeMillis();
		
		// for every item in mutations
		for (int item : mutations)
		{
			// positive items need to be inserted
			if (item > 0) 
			{
				insert(item);
			} // negative items need to be extracted
			else 
			{
				// if extraction not possible return -1
				if (extract(item) != true) 
				{
					return -1;
				}
			}
		}

		// log end time and return elapsed time
		long end = System.currentTimeMillis();
		return end - start;
	}
}