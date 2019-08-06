import java.util.*;
import java.lang.*;
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
			int n = Integer.parseInt(br1.readLine());
			boolean acorrect = false;
			boolean lcorrect = false;
			String [] numString = br1.readLine().split(" ");
			Integer [] arr = new Integer[n];
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(numString[i]);
			if(arr[1]*2==(arr[0]+arr[2]))
				acorrect = true;
			if(arr[1]*2!=(arr[0]+arr[2]) && arr[2]*2!=(arr[1]+arr[3]))
				acorrect = true;
			if(arr[1]*2!=(arr[0]+arr[2]) && arr[2]*2==(arr[1]+arr[3]))
				{
					arr[0] = arr[1] - (arr[2] - arr[1]);
					acorrect = false;
				}
			if(arr[n-2]*2==(arr[n-1]+arr[n-3]))
				lcorrect = true;
			if(arr[n-2]*2!=(arr[n-1]+arr[n-3]) && arr[n-3]*2!=(arr[n-2]+arr[n-4]))
				lcorrect = true;
			if(arr[n-2]*2!=(arr[n-1]+arr[n-3]) && arr[n-3]*2==(arr[n-2]+arr[n-4]))
			{
				arr[n-1] = arr[n-2] + (arr[n-2] - arr[n-3]);
				lcorrect = false;
			}
			if(acorrect && lcorrect)
			{
				int d = (arr[n-1]-arr[0])/(n-1);
				for(int i=0;i<n-1;i++)
					arr[i+1] = arr[i] + d;
			}
			for(int i=0;i<n;i++)
				System.out.print(arr[i]+" ");
			System.out.println("");
		}
	}
}