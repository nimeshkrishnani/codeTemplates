import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

	static class Interval
	{
		int arrival;
		int departure;
		public Interval(int arrival, int departure)
		{
			this.arrival = arrival;
			this.departure = departure;
		}

	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int numTest= Integer.parseInt(br1.readLine());
	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
	    	// System.out.println("testcase");
	    	String temp1 = br1.readLine();
			int n = Integer.parseInt(temp1);
			int maxPlatforms = 0;
			String [] temp = br1.readLine().split(" ");
			int [] arrivals = new int[n];
			for(int i=0;i<n;i++)
				arrivals[i] = Integer.parseInt(temp[i]);
			temp = br1.readLine().split(" ");
			int [] departures = new int[n];
			int i=0;
			for(int j=0;j<n;j++)
				departures[j] = Integer.parseInt(temp[j]);
			Queue<Interval> arrdep = new LinkedList<>();
			while(i<n)
			{
				if(arrdep.peek()==null)
				{
					arrdep.add(new Interval(arrivals[i], departures[i]));
					i++;
					if(maxPlatforms<arrdep.size())
						maxPlatforms = arrdep.size();
					continue;
				}
				if(arrdep.peek().departure>=arrivals[i])
				{
					System.out.println("adding arrival for "+i);
					arrdep.add(new Interval(arrivals[i], departures[i]));
					i++;
					if(maxPlatforms<arrdep.size())
						maxPlatforms = arrdep.size();
					continue;
				}
				if(arrdep.peek().departure<arrivals[i])
				{
					System.out.println("removing arrival ");
					arrdep.remove();
					continue;
				}
			}
			System.out.println(maxPlatforms);
		}
	}
}
