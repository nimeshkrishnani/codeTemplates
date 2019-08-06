/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	public static void sortedPrinter(List<Integer> arr1,List<Integer> arr2,int n,int m)
	{
		int i = 0;
		int j = 0;
		for(int k=0;k<n+m;k++)
		{
			if(i<n-1&&j<m-1)
			{
				if(arr1.get(i)<arr2.get(j))
					System.out.print(arr1.get(i++)+" ");
				else
					System.out.print(arr2.get(j++)+" ");
			}
			else
				if(i>n-1)
					System.out.print(arr2.get(j++)+" ");
				else
					System.out.print(arr1.get(i++)+" ");
		}
		System.out.println("");
		return;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);

	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
	    	String [] temp1 = br1.readLine().split(" ");
			int n = Integer.parseInt(temp1[0]);
			int m = Integer.parseInt(temp1[1]);
			String [] temp = br1.readLine().split(" ");
			List<Integer> arr1 = new ArrayList<Integer>();
			List<Integer> arr2 = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				arr1.add(Integer.parseInt(temp[i]));
			temp = br1.readLine().split(" ");
			for(int i=0;i<m;i++)
				arr2.add(Integer.parseInt(temp[i]));
			sortedPrinter(arr1,arr2,n,m);
		}
	}	    
}