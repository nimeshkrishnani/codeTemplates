	import java.util.*;
	import java.lang.*;
	import java.io.*;

	class PowerCalculator
	{
		public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		public static long calcPower(long n,long b)
		{
			if(b==0)
				return 1;
			if(b%2==0)
			{
				long temp = calcPower(n,b/2);
				return((temp*temp)%1000000007);
			}
			if(b%2==1)
			{
				long temp = calcPower(n,b/2);
				return(n*(temp*temp)%1000000007);
			}
			return 0;
		}
		public static void main (String[] args) throws java.lang.Exception
		{
			System.out.print("Please input the number and power ");
			String [] inp = br1.readLine().split(" ");
			long n= Long.parseLong(inp[0]);
			long power = Long.parseLong(inp[1]);

		    // System.out.println("number of tests are "+numTest);
				System.out.println(calcPower(n,power));
				// System.out.println((long)10.00);
		}
	}