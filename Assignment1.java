/* 	Default constructor. Creates an empty instance of each of
 	the data structures that are to be benchmarked. */
public class Assignment1 extends java.lang.Object
{
	// variables
	private  java.util.ArrayList<java.util.List<java.lang.Integer>> lists,queues;
	

	public Assignment1() {
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