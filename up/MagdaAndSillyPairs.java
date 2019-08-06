import java.lang.*;
import java.util.*;
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
			int n = Integer.parseInt(br1.readLine());
			long oddMales = 0;
			long oddFemales = 0;
			long heightsTotal = 0;
			String [] malesString = br1.readLine().split(" ");
			String [] femalesString = br1.readLine().split(" ");
			List<Integer> males = new ArrayList<Integer>();
			List<Integer> females = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				males.add(Integer.parseInt(malesString[i]));
			for(int i=0;i<n;i++)
				females.add(Integer.parseInt(femalesString[i]));
			for(int i=0;i<n;i++)
			{
				if(males.get(i)%2==1)
					oddMales++;
				if(females.get(i)%2==1)
					oddFemales++;
				heightsTotal = heightsTotal + ((males.get(i))/2);
				heightsTotal = heightsTotal + ((females.get(i))/2);				
			}
			heightsTotal = heightsTotal + Math.min(oddMales,oddFemales);
			// System.out.println("found odd heighted males "+oddMales+" found odd heighted females "+oddFemales+" adding "+Math.min(oddMales,oddFemales));
			System.out.println(heightsTotal);
		}
	}
}