import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

	static class Triplet
	{
		int a;
		int b;
		int c;
		public Triplet(int a, int b, int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		int numTest= Integer.parseInt(br1.readLine());
	    // System.out.println("number of tests are "+numTest);
	    for(int t=0;t<numTest;t++)
	    {
	    	// System.out.println("testcase");
	    	String temp1 = br1.readLine();
			int n = Integer.parseInt(temp1);
			String [] temp = br1.readLine().split(" ");
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i=0;i<n;i++)
				arr.add(Integer.parseInt(temp[i]));
			ArrayList<Triplet> triplets = new ArrayList<>();
			ArrayList<Integer> squares = new ArrayList<>();
			for(int i=1;i<=1500;i++)
				squares.add(i*i);
			for(int i=1;i<=1000;i++)
				for(int j=1;j<=1000;j++)
				{
					if(Collections.binarySearch(squares, ((i*i)+(j*j)))>=0)
						triplets.add(new Triplet(i,j,Collections.binarySearch(squares, ((i*i)+(j*j)))+1));
				}
			Collections.sort(arr);
			// System.out.println("List of triplets :");

			// for(int i=0;i<triplets.size();i++)
			// {
			// 	System.out.println(triplets.get(i).a+" "+triplets.get(i).b+" "+triplets.get(i).c);
			// }
			for(int i=0;i<triplets.size();i++)
			{
				if(Collections.binarySearch(arr, (triplets.get(i).a))>=0&&Collections.binarySearch(arr, (triplets.get(i).b))>=0&&Collections.binarySearch(arr, (triplets.get(i).c))>=0)
				{
					System.out.println("Yes");
					return;
				}
			}
		}
	}
}