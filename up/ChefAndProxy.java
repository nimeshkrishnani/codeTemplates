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
				String daysString = br1.readLine();
				double numDays = Double.parseDouble(daysString);
				String [] attendance = br1.readLine().split("");
				int proxyAvailable = 0;
				int presents = 0;
				for(int i=2;i<numDays-2;i++)
					if((attendance[i-1].equals("P")||attendance[i-2].equals("P"))&&(attendance[i+1].equals("P")||attendance[i+2].equals("P"))&&(attendance[i].equals("A")))
						proxyAvailable++;
				for(int i=0;i<numDays;i++)
					if(attendance[i].equals("P"))
						presents++;
				// System.out.println("number of days are "+numDays+" number of days to be present are "+Math.ceil((.75)*numDays)+" number of days present are "+presents+" number of proxies available are "+proxyAvailable);
				if(4*(presents)>=3*numDays)
					System.out.println(0);
				if(4*(presents)<3*numDays&&4*(presents+proxyAvailable)>=3*numDays)
					System.out.println(Math.round(Math.ceil((.75)*numDays)-presents));
				if(4*(presents+proxyAvailable)<3*numDays)
					System.out.println(-1);
			}
		}
	}