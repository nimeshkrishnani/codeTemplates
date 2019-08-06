import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	static int max(int a, int b)
	{
		if(a>=b)
			return a;
		else
			return b;
	}
	static int lcs(String [] inp1, String [] inp2, int n, int m, int[][] d)
	{
		if(n==0||m==0)
		{
			d[n][m] = 0;
			return 0;
		}
		else
			if(d[n][m]!=-1)
				return d[n][m];
			else
			{
				if(inp1[n-1].equals(inp2[m-1]))
				{
					d[n][m] = 1 + lcs(inp1, inp2, n-1, m-1, d);
					return d[n][m];
				}
				else
				{
					d[n][m] = max(lcs(inp1, inp2, n-1, m, d),lcs(inp1, inp2, n,m-1, d));
					return d[n][m];
				}
			}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);
		String [] inp;
		String [] inpreverse;
		int [][] d;
		int n,m;
		int res;
	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
	    	inp = br1.readLine().split("");
	    	inpreverse = new String[inp.length];
	    	for(int i=0;i<inp.length;i++)
	    		inpreverse[i] = inp[inp.length - i - 1];
	    	n = inp.length;
	    	m = inpreverse.length;
	    	d = new int[n+1][m+1];
	    	for(int i=0;i<n+1;i++)
	    		for(int j=0;j<m+1;j++)
	    			d[i][j] = -1;
	    	res = lcs(inp, inpreverse, n, m, d);
	    	System.out.println(inp.length - res);
	    	// System.out.println(res);
	    	// System.out.print("-");
	    	// for(int i=0;i<n;i++)
	    	// 	System.out.print(" "+inp[i]);
	    	// System.out.println("");
	    	// System.out.print("- ");
	    	// for(int j=0;j<m+1;j++)
	    	// 	System.out.print(d[0][j]+" ");
	    	// System.out.println("");
	    	// for(int i=1;i<n+1;i++)
	    	// {
	    	// 	System.out.print(inpreverse[i-1]);
	    	// 	for(int j=0;j<m+1;j++)
	    	// 		System.out.print(" "+d[i][j]);
	    	// 	System.out.println("");
	    	// }
	    }
	}
}
