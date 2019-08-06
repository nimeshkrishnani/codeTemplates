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
	public static int min(int a, int b)
	{
		if(a>b)
			return b;
		else
			return a;
	} 
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);

	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
			int coins = Integer.parseInt(br1.readLine());
			int [] coinvalues = new int[coins];
			String [] temp = br1.readLine().split(" ");
			for(int i=0;i<coins;i++)
				coinvalues[i] = Integer.parseInt(temp[i]);
			int value = Integer.parseInt(br1.readLine());
			Arrays.sort(coinvalues);
			int [][] d = new int[value+1][coins];
			for(int i=1;i<value+1;i++)
				if(i%coinvalues[0]==0)
					d[i][0] = 1;
				else
					d[i][0] = 0;
			for(int j=1;j<coins;j++)
			{
				if(coinvalues[j]>value)
				{
					System.out.println(d[value][j-1]);
					return;
				}
				for(int i=1;i<coinvalues[j];i++)
					d[i][j] = d[i][j-1];
				d[coinvalues[j]][j] = d[coinvalues[j]][j-1] + 1;
				for(int i=coinvalues[j]+1;i<value+1;i++)
					d[i][j] = d[i][j-1] + d[i - coinvalues[j]][j];
			}
			System.out.println("the array");
			for(int i=0;i<=value;i++)
			{
				System.out.print("value :"+i);
				for(int j=0;j<coins;j++)
					System.out.print(" "+d[i][j]);
				System.out.println("");
			}
			System.out.println(d[value][coins-1]);
		}
		return;
	}
}