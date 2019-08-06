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
			String [] temp = br1.readLine().split(" ");
			ArrayList<Long> arr = new ArrayList<Long>();
			for(int i=0;i<n;i++)
				arr.add(Long.parseLong(temp[i]));
			int students = Integer.parseInt(br1.readLine());
			Collections.sort(arr);
			Long mindiff = Long.MAX_VALUE;
			for(int i=0;i<n-students+1;i++)
			{
				if(mindiff>(arr.get(i+students-1)-arr.get(i)))
					mindiff = arr.get(i+students-1)-arr.get(i);
			}
			System.out.println(mindiff);
		}
	}
}