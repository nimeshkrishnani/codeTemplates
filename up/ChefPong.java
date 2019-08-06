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
			String [] inpString = br1.readLine().split(" ");
			long x = Long.parseLong(inpString[0]);
			long y = Long.parseLong(inpString[1]);
			long k = Long.parseLong(inpString[2]);
			if(((x+y)/k)%2==0)
				System.out.println("Chef");
			else
				System.out.println("Paja");
		}
	}
}