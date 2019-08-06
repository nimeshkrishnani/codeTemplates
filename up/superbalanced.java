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
	    int maxstack = 0;
	    String [] temp;
	    for(int t=0;t<numTest;t++)
	    {
	    	maxstack = 0;
	    	String [] inp = br1.readLine().split("");
	    	int [] openingbefore = new int[inp.length];
	    	int [] closingafter = new int[inp.length];
	    	int opening = 0;
	    	int closing = 0;
	    	for(int i=0;i<inp.length;i++)
	    	{
	    	    if(inp[i].equals("("))
	    	    opening++;
	    	    openingbefore [i] = opening;
	    	    if(inp[inp.length-1-i].equals(")"))
	    	    closing++;
	    	    closingafter[inp.length-1 - i] = closing;
    		}
    		for(int i=0;i<inp.length;i++)
    		    if(maxstack<Math.min(openingbefore[i],closingafter[i])*2)
    		        maxstack = openingbefore[i]+closingafter[i];
	    	System.out.println((maxstack/2)*2);
    	}
	}
}
