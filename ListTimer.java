public class ListTimer extends CollectionTimer
{
	private java.util.List<java.lang.Integer> list;

	public ListTimer(java.util.List<java.lang.Integer> list)
	{
		temp = CollectionTimer();
		temp.list = list;
	}

	public ListTimer(java.util.List<java.lang.Integer> list, long elemGenSeed)
	{
		temp = CollectionTimer(elemGenSeed);
		temp.list = list;
	}

	public ListTimer(java.util.List<java.lang.Integer> list, java.lang.Long elemGenSeed)
	{


	}

	public void addElement(java.lang.Integer elem)
	{
		list.add(elem);
	}

	public void removeElement()
	{
		if (list.size > 0)
		{
			throw new java.lang.IndexOutOfBoundsException();
		} 
		else 
		{
			list.remove(0);
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