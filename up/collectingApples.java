import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	static void twodprinter(long [][] a, int n, int m)
	{
		String [] temp = Arrays.deepToString(a).split("], ");
		for(int i=0;i<n;i++)
			System.out.println(temp[i]);
	// 	// {
	// 	// 	for(int j=0;j<m;j++)
	// 	// 		System.out.print(a[i][j]+" ");
	// 	// 	System.out.println("");
	// 	// }
	}
	static long min(long a, long b)
	{return a>b?b:a;}
	static long max(long a, long b)
	{return a>b?a:b;}
	static void milkiszero(long [][] dp, int i, long [] apples, long n)
	{
		dp[0][i+1] = -1;
		if(dp[0][i]!=-1)
			dp[0][i] = dp[0][i] + apples[i];
		for(int j=1;j<=n;j++)
			if(dp[j][i]!=-1)
				dp[j-1][i+1] = apples[i] + dp[j][i];
		return;
	}
	static void filler(long [][] dp, int i, long [] milk, long [] apples, long n)
	{
		if(milk[i]==0)
		{
			milkiszero(dp, i, apples ,n);
			return;
		}
		// System.out.println("milk at "+i+" is "+milk[i]);
		
		if(dp[0][i]!=-1)
		{
			dp[(int)min(milk[i]-1,n)][i+1] = dp[0][i];
			dp[0][i] = dp[0][i] + apples[i];
		}

		for(int j=1;j<=n;j++)
		{
			if(dp[j][i]!=-1)
			{
				// System.out.println("updating with drinking milk for "+((int)min((j+((int)milk[i])-1),n))+" and "+(i+1)+" with max value "+(max(dp[(int)min((j+((int)milk[i])-1),n)][i+1], dp[j][i])));
				dp[j-1][i+1] = max(dp[j-1][i+1], dp[j][i] + apples[i]);
				// System.out.println("selecting max elements from "+dp[(int)min((j+((int)milk[i])-1),n)][i+1]+" and "+dp[j][i]);
				dp[(int)min((j+((int)milk[i])-1),n)][i+1] = max(dp[(int)min((j+((int)milk[i])-1),n)][i+1], dp[j][i]);
			}
		}
		System.out.println("after filling for "+i+"the dp table is ");
		twodprinter(dp,(int)(n+1),(int)(n+2));
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);
	    // System.out.println("number of tests are "+numTest);
	    long max = 0,n=0,k=0,sum=0;
	    long [] milk,apples;
	    long [][] dp;
	    String [] temp;
	    for(int t=0;t<numTest;t++)
	    {
	    	temp = br1.readLine().split(" ");
	    	n = Long.parseLong(temp[0]);
	    	k = Long.parseLong(temp[1]);
	    	System.out.println("number of farms for test "+(t+1)+" are "+n);

	    	if(k==0)
	    	{
	    		// System.out.println(0);
	    		continue;
	    	}
	    	if(k>=n)
	    	{
		    	temp = br1.readLine().split(" ");
		    	temp = br1.readLine().split(" ");
	    		sum = 0;
	    		for(int i=0;i<n;i++)
	    			sum += Long.parseLong(temp[i]);
	    		// System.out.println(sum);
	    		continue;
	    	}
	    	milk = new long[(int)n+1];
	    	apples = new long[(int)n+1];

	    	dp = new long[(int)n+1][(int)n+2];
	    	int errindex = 0;

	    	temp = br1.readLine().split(" ");
	    	for(int i=1;i<=n;i++)
		    	milk[i] = Long.parseLong(temp[i-1]);
		    
		    temp = br1.readLine().split(" ");
		    try{
	    	for(int i=1;i<=n;i++)
	    	{
		    	apples[i] = Long.parseLong(temp[i-1]);
		    	errindex = i;
	    	}
			}
			catch(Exception ArrayIndexOutOfBoundsException)
			{
				System.out.println(" out of bound at "+(t+1));
				System.out.println("trying to access "+errindex+" from apples and "+(errindex-1)+" from inp when number of farms are "+n);
			}

		    for(int i=0;i<n+1;i++)
		    	for(int j=0;j<n+2;j++)
		    		dp[i][j] = -1;
		    dp[(int)k-1][1] = 0;
		    for(int i=1;i<=n;i++)
		    	filler(dp, i, milk, apples, n);
		    for(int i=0;i<=n;i++)
		    	max = max(dp[i][(int)n+1], max);
		    for(int i=0;i<n+2;i++)
		    	max = max(dp[0][i], max);
	    	// System.out.println(max);
	    }
	}
}
