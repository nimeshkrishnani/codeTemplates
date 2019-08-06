import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	public static long countTriplets(List<Integer> arr,int pos,long tripletCount)
	{
		int i = 0;
		int j = pos-1;
		int req = arr.get(pos);
		while(j>i)
		{
			// System.out.println("using i = "+i+" and j = "+j);
			if(req>arr.get(i)+arr.get(j))
				i++;
			else
				if(req<arr.get(i)+arr.get(j))
					j--;
				else
					{;i++;j--;tripletCount++;}
		}
		// System.out.println("i became "+i+" and j became "+j);
		return tripletCount;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);

	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
	    	// System.out.println("testcase");
	    	String temp1 = br1.readLine();
			int n = Integer.parseInt(temp1);
			long tripletCount = 0;
	    	// long s = Long.parseLong(temp[1]);
			String [] temp = br1.readLine().split(" ");
			List<Integer> arr = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				arr.add(Integer.parseInt(temp[i]));
			Collections.sort(arr);
			for(int i=2;i<n;i++)
				tripletCount = countTriplets(arr,i,tripletCount);
			if(tripletCount==0)
				System.out.println("-1");
			else
				System.out.println(tripletCount);
		}
	}
}