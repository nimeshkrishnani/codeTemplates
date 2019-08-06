import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	static void swap(int [] arr, int i, int j)
	{
		// System.out.println("swapping "+i+" and "+j);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}
	static void permutePrinter(int [] arr, int start, int n)
	{
		if(start==n)
		{
			for(int i=0;i<n;i++)
				System.out.print(arr[i]+" ");
			System.out.println("");
		}
		else{
			for(int i=start;i<n;i++)
			{
				swap(arr,start,i);
				permutePrinter(arr, start+1, n);
				swap(arr,start,i);
			}
		}
		return;
	}
	static void permutePrinter(int [] arr, int n)
	{
			permutePrinter(arr,0,n);
		return;
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
	    	temp = br1.readLine().split(" ");
	    	int [] arr = new int[n];
	    	for(int i=0;i<n;i++)
	    		arr[i] = Integer.parseInt(temp[i]);
	    	permutePrinter(arr, n);
	    }
	}
}
