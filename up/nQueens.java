import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<int []> permutes = new ArrayList<int []>();
	void allplaced(int [] placed_j, int n)
	{
		System.out.print("["+(placed_j[n-1]));
		for(int i=n-2;i>=0;i--)
			System.out.print(" "+(placed_j[i]));
		System.out.print("] ");
		// System.out.println(Arrays.toString(placed_j));
		return;
	}
	static int abdiff(int a, int b)
	{return a>b?a-b:b-a;}
	static boolean checkConflicts(int [] arr, int n)
	{
		for(int i=1;i<n;i++)
			for(int j=0;j<i;j++)
				if((i-j)==abdiff(arr[j],arr[i]))
				return false;
		return true;
	}

	static void swap(int [] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}

	static void placeQueen(int [] arr, int start, int n)
	{
		if(start==n)
		{
			// System.out.println(Arrays.toString(arr));
			if(checkConflicts(arr,n))
			{
				// System.out.println("didn't conflict on "+Arrays.toString(arr));
				permutes.add(arr.clone());
			}
		}
		else{
			for(int i=start;i<n;i++)
			{
				swap(arr,start,i);
				placeQueen(arr, start+1, n);
				swap(arr,start,i);
			}
		}
		return;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);
	    // System.out.println("number of tests are "+numTest);
	    int [] arr;
	    for(int t=0;t<numTest;t++)
	    {
	    	int n = Integer.parseInt(br1.readLine());
	    	arr = new int[n];
	    	for(int i=0;i<n;i++)
	    		arr[i] = n-i;
	    	placeQueen(arr,0,n);
	    	Codechef c = new Codechef();
	    	for(int i=0;i<permutes.size();i++)
	    		c.allplaced(permutes.get(i),n);
	    	System.out.println("");
	    }
	}
}
