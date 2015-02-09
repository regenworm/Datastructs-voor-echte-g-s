import java.util.*;
import java.lang.*;


public abstract class CollectionTimer extends Object
{
	public static final int[] DEFAULT_MUTATIONS = {10000, -10000};
	private Random elemGen;

	public CollectionTimer()
	{
		elemGen = new Random(0);
	}

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
		for (int i = 0; i < amount; i++)
		{
			addElement(elemGen.nextInt());
		}

	}

	public boolean extract(int amount)
	{
		try
		{
			for (int i = 0; i < amount; i++)
			{
				removeElement();
			}
			return true;
		}
		catch (RuntimeException exception)
		{
			return false;
		}

	}

	public long time()
	{
		return time(DEFAULT_MUTATIONS);
	}

	public long time(int[] mutations)
	{
		long start = System.currentTimeMillis();
		
		for (int item : mutations)
		{
			if (item > 0) 
			{
				insert(item);
			}
			else 
			{
				extract(item);
			}
		}

		long end = System.currentTimeMillis();
		return end - start;
	}
}