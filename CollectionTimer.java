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
		elemGen = new Random(elemGenSeed);
	}

	public abstract void removeElement()
	{

	}

	public abstract int getSize()
	{
		return size;
	}

	public abstract boolean isEmpty()
	{
		if (size > 0)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}

	public void insert(int amount)
	{

	}

	public boolean extract(int amount)
	{
		if (size >= amount)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public long time()
	{

	}

	public long time(int[] mutations)
	{

	}
}