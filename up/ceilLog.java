	import java.util.*;
	import java.lang.*;
	import java.io.*;

	class Codechef
	{
		public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		public static long ceilLog(long n,long b)
		{
			int result=0;
			int flag = 0;
			for(long i=n;i>1;i=i/b)
				{
					result++;
					if(n%2!=0)
						flag = 1;
				}
			if(flag == 1)
				result++;
			return result;
		}
		public static void main (String[] args) throws java.lang.Exception
		{
			System.out.print("Please input the number and base ");
			String [] inp = br1.readLine().split(" ");
			long n= Long.parseLong(inp[0]);
			long base= Long.parseLong(inp[1]);

		    // System.out.println("number of tests are "+numTest);
				System.out.println(ceilLog(n,base));
				// System.out.println((long)10.00);
		}
	}