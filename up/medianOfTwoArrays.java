	import java.util.*;
	import java.lang.*;
	import java.io.*;

	class Codechef
	{
    public static int elementPositionFinder(int element, List<Integer> arr, int i,int j)
    {
    	if(i==j||i==j-1)
    		return j;
    	if(element<=arr.get((i+j)/2))
    	{
    		System.out.println("found element "+element+" greater than the middle element "+arr.get((i+j)/2));
    		System.out.println("now searching between "+i+" and "+(((i+j)/2)));
    		return elementPositionFinder(element,arr,i,(((i+j))/2));
    	}
    	else
    	{
    		System.out.println("found element "+element+" less than or equal to the middle element "+arr.get((i+j)/2));
    		System.out.println("now searching between "+(((i+j)/2))+" and "+j);
    		return elementPositionFinder(element,arr,(((i+j))/2),j);
    	}
    }
		public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		public static void main (String[] args) throws java.lang.Exception
		{
			String numTestString = br1.readLine();
			int numTest= Integer.parseInt(numTestString);

		    // System.out.println("number of tests are "+numTest);
		    for(int t=0;t<numTest;t++)
		    {
		    	List<Integer> a = new ArrayList<Integer>();
		    	a.add(1);
		    	a.add(2);
		    	a.add(3);
		    	a.add(4);
		    	a.add(15);
		    	a.add(19);
		    	a.add(21);
		    	a.add(23);
		    	a.add(24);
		    	a.add(55);
		    	System.out.println(elementPositionFinder(1, a, 0, a.size()-1));
		    	System.out.println(elementPositionFinder(2, a, 0, a.size()-1));
		    	System.out.println(elementPositionFinder(12, a, 0, a.size()-1));
		    	System.out.println(elementPositionFinder(19, a, 0, a.size()-1));
		    	System.out.println(elementPositionFinder(22, a, 0, a.size()-1));
		    	System.out.println(elementPositionFinder(25, a, 0, a.size()-1));
			}
		}
	}