/* 	Default constructor. Creates an empty instance of each of
 	the data structures that are to be benchmarked. */
import java.util.*;
import java.lang.*;

public class Assignment1 extends Object
{
	// variables
	private  ArrayList<List<Integer>> lists;
	private  ArrayList<Queue<Integer>> queues;
	

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

	public static void main(String[] args)
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
			long seed = Long.parseLong(args[1]);
			if (args.length > 1)
			{
				int[] mutations = new int[args.length-2];
				for (int i = 0; i < args.length; i++)
				{
					mutations[i] = Integer.parseInt(args[i+2]);
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
			int[] mutations = new int[args.length];
			for (int i = 0; i < args.length; i++)
			{
				mutations[i] = Integer.parseInt(args[i]);
			}
			ass1.benchmark(0, mutations);
		}


	}

	public void benchmark() 
	{
		Assignment1 bench = new Assignment1();
		for (List<Integer> list : bench.lists) {
			ListTimer timer = new ListTimer(list);
			System.out.println(list.getClass().getSimpleName() +
				" = " + timer.time() + " milliseconds.");
		}

		for (Queue<Integer> queue : bench.queues) {
			QueueTimer timer = new QueueTimer(queue);
			System.out.println(queue.getClass().getSimpleName() +
				" = " + timer.time() + " milliseconds.");
			
		}
	}

	public void benchmark(long elemGenSeed) 
	{
		Assignment1 bench = new Assignment1();
		for (List<Integer> list : bench.lists) {
			ListTimer timer = new ListTimer(list, elemGenSeed);
			System.out.println(list.getClass().getSimpleName() +
				" = " + timer.time() + " milliseconds.");
		}

		for (Queue<Integer> queue : bench.queues) {
			QueueTimer timer = new QueueTimer(queue, elemGenSeed);
			System.out.println(queue.getClass().getSimpleName() +
				" = " + timer.time() + " milliseconds.");
			
		}
	}

	public void benchmark(long elemGenSeed, int[] mutations) 
	{
		Assignment1 bench = new Assignment1();
		for (List<Integer> list : bench.lists) {
			ListTimer timer = new ListTimer(list, elemGenSeed);
			long time = timer.time(mutations);
			System.out.println(list.getClass().getSimpleName() +
				" = " + time + " milliseconds.");
		}

		for (Queue<Integer> queue : bench.queues) {
			QueueTimer timer = new QueueTimer(queue, elemGenSeed);
			long time = timer.time(mutations);
			System.out.println(queue.getClass().getSimpleName() +
				" = " + time + " milliseconds.");
			
		}
	}

	private static void errorExit(String msg) 
	{
		System.err.println(msg);
		System.exit(1);
	}

	
}