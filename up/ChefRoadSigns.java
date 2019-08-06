	import java.util.*;
	import java.lang.*;
	import java.io.*;

	class Codechef
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
			String numTestString = br1.readLine();
			int numTest= Integer.parseInt(numTestString);

		    // System.out.println("number of tests are "+numTest);
		    for(int t=0;t<numTest;t++)
		    {
				String kString = br1.readLine();
				long k = Long.parseLong(kString);
				long powTwo = 1;
				powTwo = calcPower(2,k-1);
				System.out.println((10*powTwo)%1000000007);
				// System.out.println((long)10.00);
			}
		}
	}