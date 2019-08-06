import java.lang.*;
import java.util.*;
import java.io.*;

class Pair{
	int data1;
	int data2;
}
class SortByData1 implements Comparator<Pair>{
	public int compare(Pair a, Pair b){
		if(a.data1>b.data1)
			return 1;
		else
			if(a.data1==b.data1)
				return 0;
			else
				return -1;
	}
}
class SortByData2 implements Comparator<Pair>{
	public int compare(Pair a, Pair b){
		if(a.data2>b.data2)
			return 1;
		else
			if(a.data2==b.data2)
				return 0;
			else
				return -1;
	}
}
class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	void pairPrinter(Pair [] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i].data1+" ");
		System.out.println("");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i].data2+" ");
		System.out.println("");
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String numTestString = br1.readLine();
		int numTest= Integer.parseInt(numTestString);
	    // System.out.println("number of tests are "+numTest);
	    String [] temp;
	    for(int t=0;t<numTest;t++)
	    {
	    	int n = Integer.parseInt(br1.readLine());
	    	System.out.println("n is equal to "+n);
	    	temp = br1.readLine().split(" ");
	    	Pair arr[] = new Pair[n];
	    	for(int i=0;i<n;i++)
	    		arr[i] = new Pair();
	    	for(int i=0;i<n;i++)
	    		arr[i].data1 = Integer.parseInt(temp[i]);
	    	temp = br1.readLine().split(" ");
	    	for(int i=0;i<n;i++)
	    		arr[i].data2 = Integer.parseInt(temp[i]);
	    	Codechef c = new Codechef();
	    	SortByData1 sortdata1 = new SortByData1();
	    	SortByData2 sortdata2 = new SortByData2();
	    	c.pairPrinter(arr);
	    	Arrays.sort(arr, sortdata1);
	    	c.pairPrinter(arr);
	    	Arrays.sort(arr, sortdata2);
	    	c.pairPrinter(arr);
	    }
	}
}
