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
	    	String [] temp1 = br1.readLine().split(" ");
			int n = Integer.parseInt(temp1[0]);
			int m = Integer.parseInt(temp1[1]);
			int pairCount = 0;
			int numzeros = 0;
			int numOnesZeros = 0;
	    	// long s = Long.parseLong(temp[1]);
			String [] temp = br1.readLine().split(" ");
			List<Integer> arr1 = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				arr1.add(Integer.parseInt(temp[i]));
			temp = br1.readLine().split(" ");
			List<Integer> arr2 = new ArrayList<Integer>();
			for(int i=0;i<m;i++)
				arr2.add(Integer.parseInt(temp[i]));
			Collections.sort(arr2);
			for(int i=0;i<n;i++)
			{
				if(arr1.get(i)==0||arr1.get(i)==1)
					numOnesZeros++;
				if(arr1.get(i)==0)
					numzeros++;
				if(arr1.get(i)==1)
					pairCount += Collections.frequency(arr2, 0);
				if(arr1.get(i)==2)
				{
					System.out.println("found 2 at "+i+" found 4 in the other array at "+Collections.binarySearch(arr2, 4));
					if(Collections.binarySearch(arr2, 4)>-1)
					{
						System.out.println("found 4 for 2 at "+Collections.binarySearch(arr2, 4));
						pairCount = pairCount + (m-(Collections.binarySearch(arr2, 4)));
					}
					else
					{
						System.out.println("couldn't find 4 for 2 but the position should be "+Collections.binarySearch(arr2, 4));
						pairCount = pairCount + (m - ((Collections.binarySearch(arr2, 4)+1)*-1));					
					}
				}
				if(arr1.get(i)==3)
					pairCount = pairCount + Collections.frequency(arr2, 2);
				if(arr1.get(i)>3)
					if(Collections.binarySearch(arr2, 4)>-1)
					{
						System.out.println("found "+(arr1.get(i))+" for "+arr1.get(i)+" at "+Collections.binarySearch(arr2, arr1.get(i)));
						pairCount = pairCount + (m-(Collections.binarySearch(arr2, arr1.get(i))));
						System.out.println("increasing count by "+(m-(Collections.binarySearch(arr2, arr1.get(i)))));
					}
					else
					{
						System.out.println("found "+(arr1.get(i)+1)+" for "+arr1.get(i)+" at "+Collections.binarySearch(arr2, arr1.get(i)+1));
						pairCount = pairCount + (m - ((Collections.binarySearch(arr2, arr1.get(i)+1)+1)*-1));					
						System.out.println("increasing count by "+(m - ((Collections.binarySearch(arr2, arr1.get(i)+1)+1)*-1)));
					}

					// if(Collections.binarySearch(arr2, arr1.get(i))>-1)
					// 	pairCount = pairCount + (m-(Collections.binarySearch(arr2, arr1.get(i))));
					// else
					// 	pairCount = pairCount + (m - ((Collections.binarySearch(arr2, arr1.get(i))+1)*-1));

			}
			Collections.sort(arr2);
			Collections.sort(arr1);
			pairCount += Collections.frequency(arr2, 0)*(n - numzeros);
			pairCount += Collections.frequency(arr2, 1)*(n - numOnesZeros);
			System.out.println("number of zeros "+numzeros+" number of ones and zeros "+numOnesZeros);
			System.out.println(pairCount);
			System.out.println(arr1);
			System.out.println(arr2);
		}
	}
}
