/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	public static int mNum(List<Integer> arr,int n)
	{
		int xor = 0;
		for(int i=1;i<=n;i++)
			xor = i^xor;
		for(int i=0;i<n-1;i++)
			xor = xor^(arr.get(i));
		return xor;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);

	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
	    	String temp1 = br1.readLine();
			int n = Integer.parseInt(temp1);
			String [] temp = br1.readLine().split(" ");
			List<Integer> arr = new ArrayList<Integer>();
			for(int i=0;i<n-1;i++)
				arr.add(Integer.parseInt(temp[i]));
			System.out.println(mNum(arr,n));
		}
	}	    
}