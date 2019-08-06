import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	static boolean positionMatcher(ArrayList<char []> in, int i)
	{
		// System.out.println("matching position for "+i);
		char commonChar = in.get(0)[i];
			for(int j=0;j<in.size();j++)
			if(in.get(j)[i]!=commonChar)
				return false;
		return true;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);
	    // System.out.println("number of tests are "+numTest);
	    String [] temp;
	    for(int t=0;t<numTest;t++)
	    {
	    	int n = Integer.parseInt(br1.readLine());
	    	int minlength = Integer.MAX_VALUE;
	    	boolean foundallmatching = true;
	    	String [] inp = br1.readLine().split(" ");
	    	ArrayList<char []> in = new ArrayList<char []>();
	    	for(int i=0;i<inp.length;i++)
	    		in.add(inp[i].toCharArray());
	    	// System.out.println(in.get(0)[0]);
	    	for(int i=0;i<inp.length;i++)
	    		if(in.get(i).length<minlength)
	    			minlength = in.get(i).length;
	    	for(int i=0;i<minlength;i++)
	    		if(!positionMatcher(in,i))
	    		{
	    			System.out.println(i);
	    			foundallmatching = false;
	    			break;
	    		}
    		if(foundallmatching)
	    	System.out.println(minlength);
	    }
	}
}
