	import java.util.*;
	import java.lang.*;
	import java.io.*;

	class Codechef
	{
		public static void setZeroes(ArrayList<ArrayList<Integer>> a)
		{
			ArrayList<Integer> rowsZero = new ArrayList<Integer>();
			ArrayList<Integer> columnsZero = new ArrayList<Integer>();
			for(int i=0;i<a.size();i++)
				for(int j=0;j<a.get(i).size();j++)
				{
					// System.out.println("Accessing "+i+","+j);
					 if(a.get(i).get(j)==0)
					 {
					 	// System.out.println("found a zero on "+i+","+j);
					 	rowsZero.add(i);
					 	columnsZero.add(j);
					 }
				}
			Set<Integer> temprows = new HashSet<Integer>(rowsZero);
			Set<Integer> tempcols = new HashSet<Integer>(columnsZero);
			// System.out.println(temprows);
			// System.out.println(tempcols);
			rowsZero.clear();
			rowsZero.addAll(temprows);
			columnsZero.clear();
			columnsZero.addAll(tempcols);
			// System.out.println(rowsZero);
			// System.out.println(columnsZero);
			if(rowsZero.size()>0)
			{
			for(int i=0;i<rowsZero.size();i++)
				for(int j=0;j<a.get(rowsZero.get(i)).size();j++)
					a.get(rowsZero.get(i)).set(j,0);
			for(int i=0;i<a.size();i++)
				for(int j=0;j<columnsZero.size();j++)
					a.get(i).set(columnsZero.get(j),0);
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
		    	ArrayList <ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		    	a.add(new ArrayList<Integer>());
		    	a.add(new ArrayList<Integer>());
		    	a.add(new ArrayList<Integer>());
		    	a.get(0).add(1);
		    	a.get(0).add(0);
		    	a.get(0).add(1);
		    	a.get(1).add(1);
		    	a.get(1).add(0);
		    	a.get(1).add(1);
		    	a.get(2).add(1);
		    	a.get(2).add(1);
		    	a.get(2).add(1);
		    	System.out.println(a);
		    	setZeroes(a);
		    	System.out.println(a);
			}
		}
	}