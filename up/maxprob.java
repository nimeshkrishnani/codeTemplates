import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	static void visit(ArrayList<ArrayList<Integer>> g, int start, double [] probabilities, double incomingprobability, boolean [] loneIsland)
	{
		System.out.println("visiting node "+start+" with incoming probability "+incomingprobability);
		if(g.get(start).size()==0)
		{
			loneIsland[start] = true;
			probabilities[start] = probabilities[start] + incomingprobability;
		}
		else
		{
			Iterator it = g.get(start).iterator();
			while(it.hasNext())
			{
				visit(g, (Integer)it.next(), probabilities , incomingprobability/((double) g.get(start).size()), loneIsland);
			}
		}
	}
	static int max(int a, int b)
	{
		if(a>=b)
			return a;
		else
			return b;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String [] verticesEdgesStart = br1.readLine().split(" ");
		int v = Integer.parseInt(verticesEdgesStart[0]);
		int e = Integer.parseInt(verticesEdgesStart[1]);
		int start = Integer.parseInt(verticesEdgesStart[2]);
		int totalInLoneIsland = 0;
		String [] inp;
		boolean [] loneIsland = new boolean[v+1];
	    // System.out.println("number of tests are "+numTest);
	    ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
	    // ArrayList<ArrayList<Integer>> g2 = new ArrayList<ArrayList<Integer>>();
	    for(int i=0;i<=v;i++)
	    	g.add(new ArrayList<Integer>());
	    for(int t=0;t<e;t++)
	    {
	    	inp = br1.readLine().split(" ");
	    	// g2.get(Integer.parseInt(inp[1])).add(Integer.parseInt(inp[0]));
	    	g.get(Integer.parseInt(inp[0])).add(Integer.parseInt(inp[1]));
	    }
	    double [] probabilities = new double[v+1];
	    visit(g, start, probabilities, 1,loneIsland);
	    double maxprob = 0;
	    for(int i=0;i<=v;i++)
	    	if(maxprob<probabilities[i])
	    		maxprob = probabilities[i];
	    for(int i=0;i<=v;i++)
	    	if(Math.abs(maxprob - probabilities[i])<=0.000000001)
	    		System.out.print("visiting "+i+" with probability "+probabilities[i]);
	}
}
