import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

	public static int max(int a, int b)
	{
		if(a>=b)
			return a;
		else
			return b;
	} 
	public static int solver(int n, int moneyleft, int [][] dp, ArrayList<Integer> calories, ArrayList<Integer> cost)
	{
		if(moneyleft==0||n==0)
			return 0;
		else
		{
			if(dp[n][moneyleft]!=-1)
				return dp[n][moneyleft];
			else
			{
				if(moneyleft>=cost.get(n-1))
					dp[n][moneyleft] = max(solver(n-1, moneyleft, dp, calories, cost), solver(n-1, moneyleft-cost.get(n-1), dp, calories, cost)+calories.get(n-1));
				else
					dp[n][moneyleft] = solver(n-1, moneyleft, dp, calories, cost);
				return dp[n][moneyleft];
			}
		}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);

	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
			String [] temp = br1.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			int moneyleft = Integer.parseInt(temp[1]);
			temp = br1.readLine().split(" ");
			ArrayList<Integer> calories = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				calories.add(Integer.parseInt(temp[i]));
			temp = br1.readLine().split(" ");
			ArrayList<Integer> cost = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				cost.add(Integer.parseInt(temp[i]));
			int [][] dp = new int[n+1][moneyleft+1];
			for(int i=0;i<=n;i++)
				for(int j=0;j<=moneyleft;j++)
					dp[i][j]=-1;
			System.out.println(solver(n, moneyleft, dp, calories, cost));
		}
	}
}