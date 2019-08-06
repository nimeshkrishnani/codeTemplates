import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	public static int gcd(int a, int b)
	{
		if(a>=b)
			if(a%b==0)
				return b;
			else
				return gcd(b,a%b);
		else
			return gcd(b,a);
	} 
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);

	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
			int n = Integer.parseInt(br1.readLine());
			String [] temp = br1.readLine().split(" ");
			int [] arr  = new int[n];
			int [] gcd = new int[n-1];
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(temp[i]);
			for(int i=0;i<n-1;i++)
				gcd[i] = gcd(arr[i],arr[i+1]);
			for(int i=0;i<n-1;i++)
			System.out.println(gcd[i]);	
		}
	}
}