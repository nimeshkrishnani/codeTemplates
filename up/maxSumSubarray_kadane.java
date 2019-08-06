import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	public static long kadane(List<Integer> arr,int n)
	{
		long maxSum = 0;
		List<Integer> sumTillI = new ArrayList<Integer>();
		if(arr.get(0)>0)
			sumTillI.add(arr.get(0));
		else
			sumTillI.add(0);
		for(int i=1;i<n;i++)
			if(sumTillI.get(i-1)+arr.get(i)<0)
				sumTillI.add(0);
			else
				sumTillI.add(sumTillI.get(i-1)+arr.get(i));
		return Collections.max(sumTillI);
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
			long maxSum = 0;
	    	// long s = Long.parseLong(temp[1]);
			String [] temp = br1.readLine().split(" ");
			List<Integer> arr = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				arr.add(Integer.parseInt(temp[i]));
			maxSum = kadane(arr,n);
			if(maxSum==0)
				System.out.println(Collections.max(arr));
			else
				System.out.println(maxSum);
		}
	}
}