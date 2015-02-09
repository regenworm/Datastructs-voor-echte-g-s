/* 	Default constructor. Creates an empty instance of each of
 	the data structures that are to be benchmarked. */
import java.util.*;
import java.lang.*;

public class Assignment1 extends Object
{
	// variables
	private  ArrayList<List<Integer>> lists;
	private  ArrayList<Queue<Integer>> queues;
	

	// init interfaces
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

	// main code
	public static void main(String[] args)
	{
		// init class
		Assignment1 ass1 = new Assignment1();

		// If no options are added in commandline
		if (args.length == 0)
		{
			ass1.benchmark();
		} // if  seed is specified
		else if (args[0].equals("-s"))
		{
			// get seed
			long seed = Long.parseLong(args[1]);

			// if seed and mutations are specified
			if (args.length > 2)
			{
				// length mutations is length args minus seed specification
				int[] mutations = new int[args.length-2];
				
				// every arg after seed is stored in mutations after parsing
				for (int i = 0; i < mutations.length; i++)
				{
					mutations[i] = Integer.parseInt(args[i+2]);
				}

				ass1.benchmark(seed, mutations);
			} // if only seed is specified
			else
			{
				ass1.benchmark(seed);
			}
		} // if only mutations are specified
		else
		{
			// mutations is length of args
			int[] mutations = new int[args.length];

			// every arg is stored in mutations after parsing
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
			System.out.format("%-13s%3s%3d%14s%n", list.getClass().getSimpleName(),
				"=", timer.time(), "milliseconds.");
		}

		for (Queue<Integer> queue : bench.queues) {
			QueueTimer timer = new QueueTimer(queue);
			System.out.format("%-13s%3s%3d%14s%n", queue.getClass().getSimpleName(),
				"=", timer.time(),"milliseconds.");
			
		}
	}

	public void benchmark(long elemGenSeed) 
	{
		Assignment1 bench = new Assignment1();
		for (List<Integer> list : bench.lists) {
			ListTimer timer = new ListTimer(list, elemGenSeed);
			System.out.format("%-13s%3s%3d%14s%n", list.getClass().getSimpleName(),
				"=", timer.time(), "milliseconds.");
		}

		for (Queue<Integer> queue : bench.queues) {
			QueueTimer timer = new QueueTimer(queue, elemGenSeed);
			System.out.format("%-13s%3s%3d%14s%n", queue.getClass().getSimpleName(),
				"=", timer.time(),"milliseconds.");
		}
	}

	public void benchmark(long elemGenSeed, int[] mutations) 
	{
		Assignment1 bench = new Assignment1();
		for (List<Integer> list : bench.lists) {
			ListTimer timer = new ListTimer(list, elemGenSeed);
			long time = timer.time(mutations);
			System.out.format("%-13s%3s%3d%14s%n", list.getClass().getSimpleName(),
				"=", timer.time(), "milliseconds.");
		}

		for (Queue<Integer> queue : bench.queues) {
			QueueTimer timer = new QueueTimer(queue, elemGenSeed);
			long time = timer.time(mutations);
			System.out.format("%-13s%3s%3d%14s%n", queue.getClass().getSimpleName(),
				"=", timer.time(),"milliseconds.");
			
		}
	}

	private static void errorExit(String msg) 
	{
		System.err.println(msg);
		System.exit(1);
	}

	
}