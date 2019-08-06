	import java.util.*;
	import java.lang.*;
	import java.io.*;

	class Solution 
	{
		static class LargerJointNumber implements Comparator<Integer>
		{
			public int compare(Integer a,Integer b)
			{
				// return a-b;
				// return Integer.parseInt(String.valueOf(a)+String.valueOf(b))-Integer.parseInt(String.valueOf(b)+String.valueOf(a));
				if(Long.parseLong(String.valueOf(a)+String.valueOf(b))>Long.parseLong(String.valueOf(b)+String.valueOf(a)))
					return -1;
				else
					return 1;
			}
		}

	    // DO NOT MODIFY THE LIST. IT IS READ ONLY
 	    public static void LargestNumber(final List<Integer> arr) 
	    {
	    	List<Integer> arrcp = new ArrayList<Integer>();
	    	for(int i=0;i<arr.size();i++)
	    		arrcp.add(arr.get(i));
	    	Collections.sort(arrcp, new LargerJointNumber());
	    	for(int i=0;i<arrcp.size();i++)
	    		System.out.print(arrcp.get(i));
	    	System.out.println("");
	    }
	}
	class LargestValueString
	{
		public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		public static void main (String[] args) throws java.lang.Exception
		{
			System.out.print("Please input the number Sequence ");
			String [] inp = br1.readLine().split(" ");
			List<Integer> arr = new ArrayList<Integer>();
			for(int i=0;i<inp.length;i++)
				arr.add(Integer.parseInt(inp[i]));
			Solution.LargestNumber(arr);

		    // System.out.println("number of tests are "+numTest);
				// System.out.println(res);
				// System.out.println((long)10.00);
		}
	}