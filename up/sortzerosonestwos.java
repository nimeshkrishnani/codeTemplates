import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	public static void main (String[] args) throws java.lang.Exception
	{
		int numTest= Integer.parseInt(br1.readLine());
	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
	    	// System.out.println("testcase");
	    	String temp1 = br1.readLine();
			int n = Integer.parseInt(temp1);
			int countzeros=0,countones=0,counttwos=0;
			String [] temp = br1.readLine().split(" ");
			List<Integer> arr1 = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				arr1.add(Integer.parseInt(temp[i]));
			for(int i=0;i<n;i++)
			{
				if(arr1.get(i)==0)
					countzeros++;
				if(arr1.get(i)==1)
					countones++;
				if(arr1.get(i)==2)
					counttwos++;
			}
			for(int i=0;i<countzeros;i++)
				System.out.print(0+" ");
			for(int i=0;i<countones;i++)
				System.out.print(1+" ");
			for(int i=0;i<counttwos;i++)
				System.out.print(2+" ");
			System.out.println("");
		}
	}
}
