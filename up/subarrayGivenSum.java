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
	    for(int t=0;t<numTest;t++)
	    {
	    	// System.out.println("testcase");
	    	String [] temp = br1.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
	    	long s = Long.parseLong(temp[1]);
			temp = br1.readLine().split(" ");
			List<Integer> arr = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				arr.add(Integer.parseInt(temp[i]));
			// System.out.println("made array of integers");
			int i=-1;
			int j=-1;
			long sum = 0;
			while(j<n-1&&sum!=s)
			{
			// System.out.println("found sum as "+sum+" between "+i+" and "+j);
				if(s>sum)
				{
					j++;
					sum = sum + ((long) arr.get(j));
				}
				if(s<sum)
				{
					i++;
					sum = sum - ((long) arr.get(i));
				}
			}
			if(sum==s)
				System.out.println((i+2)+" "+(j+1));
			else
				System.out.println("-1");
		}
	}
}