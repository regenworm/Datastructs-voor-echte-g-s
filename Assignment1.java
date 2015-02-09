/* 	Default constructor. Creates an empty instance of each of
 	the data structures that are to be benchmarked. */
public class Assignment1 extends java.lang.Object
{
	// variables
	private  java.util.ArrayList<java.util.List<java.lang.Integer>> lists,queues;
	

	public Assignment1() 
	{
		lists = new ArrayList<List<Integer>>();
		lists.add(new ArrayList<Integer>());
		lists.add(new LinkedList<Integer>());
		lists.add(new Stack<Integer>());
		lists.add(new Vector<Integer>());

		queues = new ArrayList<Queue<Integer>>();
		queues.add(new LinkedList<Integer>());
		queues.add(new PriorityQueue<Integer>());
	}

	public static void main(java.lang.String[] args)
	{
		Assignment1 ass1 = new Assignment1();
		int useseed = 0;
		// get seed
		if (args.length == 0)
		{
			ass1.benchmark();
		}
		else if (args[0] == "-s")
		{
			long seed = args[1];
			if (args.length > 1)
			{
				for (i = 2; i < args.length; i++)
				{
					mutations[i] = Integer.parseInt(args[i]);
				}

				ass1.benchmark(seed, mutations);
			}
			else
			{
				ass1.benchmark(seed);
			}
		}
		else
		{
			for (i = 0; i < args.length; i++)
			{
				mutations[i] = Integer.parseInt(args[i]);
			}
			ass1.benchmark(0, mutations);
		}

	}

	public void benchmark() 
	{

	}

	public void benchmark(long elemGenSeed) 
	{
		
	}

	public void benchmark(long elemGenSeed, int[] mutations) 
	{
		
	}

	private static void errorExit(java.lang.String msg) 
	{
		System.err.println(msg);
		System.exit(1);
	}

	
}