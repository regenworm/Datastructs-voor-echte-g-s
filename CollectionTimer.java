public abstract class CollectionTimer extends java.lang.Object
{
	public static final int[] DEFAULT_MUTATIONS = {10000, -10000};
	private java.util.Random elemGen;

	public CollectionTimer()
	{
		elemGen = new Random(0);
	}

	public CollectionTimer(long elemGenSeed)
	{
		elemGen = new Random(elemGenSeed);
	}

	public abstract void addElement(java.lang.Integer elem)
	{

	}

	public abstract void removeElement()
	{

	}

	public abstract int getSize()
	{

	}

	public abstract boolean isEmpty()
	{

	}

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
		
		for (i = 0; i < mutations.size(); i++)
		{
			if (i > 0) 
			{
				insert(mutations[i]);
			}
			else 
			{
				extract(mutations[i])
			}
		}

		long end = System.currentTimeMillis();
		return end - start;
	}
}