import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);
	    // System.out.println("number of tests are "+numTest);
	    String [] temp;
	    for(int t=0;t<numTest;t++)
	    {
	    	temp = br1.readLine().split(" ");
	    	int n = Integer.parseInt(temp[0]),m = Integer.parseInt(temp[1]);
	    	int [] a = new int[n], b = new int[n];
	    	int [] found = new int[n];
	    	int [] inedges = new int[n];
	    	int currentNode,processingNode;
	    	boolean possible = true;
	    	temp = br1.readLine().split(" ");
	    	for(int i=0;i<n;i++)
	    		b[i] = Integer.parseInt(temp[i]);
	    	ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
	    	ArrayList<ArrayList<Integer>> g2 = new ArrayList<ArrayList<Integer>>();
	    	for(int i=0;i<n;i++)
	    		g.add(new ArrayList<Integer>());
	    	for(int i=0;i<n;i++)
	    		g2.add(new ArrayList<Integer>());
	    	for(int i=0;i<m;i++)
	    	{
	    		temp = br1.readLine().split(" ");
	    		if(temp[1].equals("<"))
	    		{
	    			g.get(Integer.parseInt(temp[0])-1).add(Integer.parseInt(temp[2])-1);
	    			inedges[Integer.parseInt(temp[2])-1] += 1;
	    		}
	    		else
	    		{
	    			g.get(Integer.parseInt(temp[2])-1).add(Integer.parseInt(temp[0])-1);
	    			inedges[Integer.parseInt(temp[0])-1] += 1;
	    		}
	    	}
	    	Queue<Integer> q = new LinkedList<>();
	    	for(int i=0;i<n;i++)
	    		if(inedges[i]==0)
	    		{
	    			q.add(i);
	    			found[i]=0;
	    		}
	    	Iterator it;
	    	while(!q.isEmpty())
	    	{
	    		currentNode = q.remove();
	    		it = g.get(currentNode).iterator();
	    		while(it.hasNext())
	    		{
	    			processingNode =(Integer) it.next();
	    			inedges[processingNode]--;
	    			found[processingNode] = found[currentNode] + 1;
	    			if(inedges[processingNode]==0)
	    				q.add(processingNode);
	    		}
	    	}
	    	for(int i=0;i<inedges.length;i++)
	    		if(inedges[i]>0)
	    		{
	    			possible = false;
	    		}
    		if(possible)
			{
		    	System.out.println("YES");
		    	for(int i=0;i<found.length;i++)
		    	{
		    		found[i] = found[i] + b[0] + 1;
		    		System.out.print(found[i]+" ");
		    	}
		    	System.out.println("");
		    }
		    else
    			System.out.println("NO");		    	
	    }
	}
}
