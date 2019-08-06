import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	static int inversions = 0;
	
	// public static void mergeSort(int [] arr, int leftStart, int rightEnd, int inversions, int [] merger)
	public static void mergeSort(int [] arr, int leftStart, int rightEnd, int [] merger)
	{
		if(leftStart>=rightEnd)
			return;
		int leftEnd = (leftStart+rightEnd)/2;
		int rightStart = leftEnd+1;
		// mergeSort(arr, leftStart, leftEnd, inversions, merger);
		// mergeSort(arr, rightStart, rightEnd, inversions, merger);
		// mergeHalves(arr, leftStart, leftEnd, rightStart, rightEnd, inversions, merger);
		mergeSort(arr, leftStart, leftEnd, merger);
		mergeSort(arr, rightStart, rightEnd, merger);
		mergeHalves(arr, leftStart, leftEnd, rightStart, rightEnd, merger);
		return;
	}
	// public static void mergeHalves(int [] arr, int leftStart, int leftEnd, int rightStart, int rightEnd, int inversions, int [] merger)
	public static void mergeHalves(int [] arr, int leftStart, int leftEnd, int rightStart, int rightEnd, int [] merger)
	{
		int i = 0;
		int n = rightEnd - leftStart + 1;
		int origin = leftStart;
		// System.out.println("sorting "+n+" elements between "+leftStart+" to "+leftEnd+" and "+rightStart+" to "+rightEnd);
		while(leftStart<=leftEnd&&rightStart<=rightEnd)
			if(arr[leftStart]>arr[rightStart])
			{
				// System.out.println("while sorting found "+(leftEnd - leftStart)+" inversion(s) "+arr[leftStart]+" and "+arr[rightStart]);
				inversions = inversions + (leftEnd - leftStart + 1);
				merger[i] = arr[rightStart];
				i++;
				rightStart++;
			}
			else
			{
				merger[i] = arr[leftStart];
				i++;
				leftStart++;
			}
		if(leftStart<=leftEnd)
			while(i<n)
			{
				merger[i] = arr[leftStart];
				leftStart++;
				i++;
			}
		else
			while(i<n)
			{
				merger[i] = arr[rightStart];
				rightStart++;
				i++;
			}
			for(int j=0;j<n;j++)
			{
				// System.out.println("accessing array on index "+(j+origin));
				arr[j+origin] = merger[j];
			}
			// System.out.println(Arrays.toString(arr));
		return;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		int numTest= Integer.parseInt(br1.readLine());
	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
	    	// System.out.println("testcase");
	    	String temp1 = br1.readLine();
			int n = Integer.parseInt(temp1);
			String [] temp = br1.readLine().split(" ");
			int [] arr1 = new int[n];
			for(int i=0;i<n;i++)
				arr1[i] = Integer.parseInt(temp[i]);
			int [] merger = new int[n];
			// mergeSort(arr1, 0, n-1, inversions, merger);
			mergeSort(arr1, 0, n-1, merger);
			System.out.println(inversions);
			// System.out.print("sorted Array ");
			// System.out.println(Arrays.toString(arr1));
		}
	}
}
