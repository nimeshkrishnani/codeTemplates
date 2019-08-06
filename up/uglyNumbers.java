import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	public static Scanner sc = new Scanner(System.in);
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
		// String numTestString = br1.readLine();
		int numTest= sc.nextInt();
	    // System.out.println("number of tests are "+numTest);
	    ArrayList<Long> uglyNums = new ArrayList<Long>();
	    uglyNums.add((long)1);
	    uglyNums.add((long)2);
	    uglyNums.add((long)3);
	    uglyNums.add((long)4);
	    uglyNums.add((long)5);
	    long n;
	    long currentElement;
    	for(int i=0;i<10002;i++)
    	{
    		for(long j=2;j<6;j++)
	    		if(Collections.binarySearch(uglyNums ,j*uglyNums.get(i))<0)
	    			uglyNums.add((Collections.binarySearch(uglyNums ,j*uglyNums.get(i)))*(-1)-1, j*uglyNums.get(i));
    	}
	    for(int t=0;t<numTest;t++)
	    {
	    	n = sc.nextLong();
	    	System.out.println(uglyNums.get((int)n-1));
	    	// System.out.println(uglyNums.toString());
	    }
	}
}
