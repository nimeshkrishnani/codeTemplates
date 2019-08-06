import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static Scanner inp = new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
		int numTest= inp.nextInt();

	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
	    	// System.out.println("testcase");
			int n = inp.nextInt();
	    	// long s = Long.parseLong(temp[1]);
			List<Long> arr = new ArrayList<Long>();
			for(int i=0;i<n;i++)
				arr.add(inp.nextLong());
			long maxElement = arr.get(n-1)+1;
			System.out.println("setting max element as "+maxElement);
			int j = 0;
			for(int i=0;i<n;i+=2)
			{
				arr.set(i, (maxElement*(arr.get(n-j-1)%maxElement))+arr.get(i));
				if(i+1<n)
					arr.set(i+1, (maxElement*(arr.get(j)%maxElement))+arr.get(i+1));
				j++;
			}
			for(int i=0;i<n;i++)
				System.out.print(arr.get(i)+" ");
			System.out.println("");
			for(int i=0;i<n;i++)
				System.out.print((arr.get(i)-(arr.get(i)%maxElement))/maxElement+" ");
		}
	}
}