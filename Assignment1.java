/* Assignment 1, Datastructuren 2015
 * Authors: Alex Khawalid, 10634207
 * 			Philip Bouman, 10668667
 * Date: 09-02-2015
 */

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
			// get seed, catch
			try
			{
				long seed = Long.parseLong(args[1]);
				// if seed and mutations are specified
				if (args.length > 2)
				{
					try
					{
						// length mutations is length args minus seed specification
						int[] mutations = new int[args.length-2];
						
						// every arg after seed is stored in mutations after parsing
						for (int i = 0; i < mutations.length; i++)
						{
							mutations[i] = Integer.parseInt(args[i+2]);
						}

						ass1.benchmark(seed, mutations);
					}
					catch (NumberFormatException nfe)
					{
						errorExit("Not a number, specify the number of operations correctly.");
					}
				} // if only seed is specified
				else
				{
					ass1.benchmark(seed);
				}
			} 
			catch(NumberFormatException nfe)
			{
				errorExit("Not a number, specify the seed number correctly.");
			}
		} // if only mutations are specified
		else
		{
			try
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
			catch (NumberFormatException nfe)
			{
				errorExit("Not a number, specify the number of operations correctly.");
			}
		}
	}
	/*
	 * Performs benchmark by applying the specified mutations and using the given 
	 * seed to populate the data structures. The result is printed to stdout. 
	 */
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
	/*
	 * Performs benchmark by applying the specified mutations and using the given 
	 * seed to populate the data structures. The result is printed to stdout. 
	 */
	public void benchmark(long elemGenSeed) 
	{
		Assignment1 bench = new Assignment1();
		for (List<Integer> list : bench.lists) {
			ListTimer timer = new ListTimer(list, elemGenSeed);
			System.out.format("%-13s%3s%4d%14s%n", list.getClass().getSimpleName(),
				"=", timer.time(), "milliseconds.");
		}

		for (Queue<Integer> queue : bench.queues) {
			QueueTimer timer = new QueueTimer(queue, elemGenSeed);
			System.out.format("%-13s%3s%4d%14s%n", queue.getClass().getSimpleName(),
				"=", timer.time(),"milliseconds.");
		}
	}
	/*
	 * Performs benchmark by applying the specified mutations and using the given 
	 * seed to populate the data structures. The result is printed to stdout. 
	 */
	public void benchmark(long elemGenSeed, int[] mutations) 
	{
		Assignment1 bench = new Assignment1();
		for (List<Integer> list : bench.lists) {
			ListTimer timer = new ListTimer(list, elemGenSeed);
			long time = timer.time(mutations);
			if (time == -1) {
				errorExit("Incorrect number of elements");
			}
			System.out.format("%-13s%3s%4d%14s%n", list.getClass().getSimpleName(),
				"=", time, "milliseconds.");
		}

		for (Queue<Integer> queue : bench.queues) {
			QueueTimer timer = new QueueTimer(queue, elemGenSeed);
			long time = timer.time(mutations);
			if (time == -1) {
				errorExit("Incorrect number of elements");
			}
			System.out.format("%-13s%3s%4d%14s%n", queue.getClass().getSimpleName(),
				"=", time,"milliseconds.");
			
		}
	}

	// print message and exit with value 1
	private static void errorExit(String msg) 
	{
		System.err.println(msg);
		System.exit(1);
	}

	
}