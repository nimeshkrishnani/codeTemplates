import java.util.*;
import java.lang.*;
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
			int numberofdays = Integer.parseInt(br1.readLine().split(" ")[0]);
			HashMap<Integer, Integer> tastinesses = new HashMap<Integer, Integer>();
			for(int i=0;i<numberofdays;i++)
			{
				String [] dayAndTastiness = br1.readLine().split(" ");
				int day = Integer.parseInt(dayAndTastiness[0]);
				int temptastiness = Integer.parseInt(dayAndTastiness[1]);
				// System.out.println("found day "+day+" and temptastiness "+temptastiness);
				// if(tastinesses.containsKey(Integer.parseInt(dayAndTastiness[0]))&&tastinesses.get(Integer.parseInt(dayAndTastiness[0]))<Integer.parseInt(dayAndTastiness[1]))
				if(tastinesses.containsKey(day)&&tastinesses.get(day)<temptastiness)
					tastinesses.put(day, temptastiness);
				if(!tastinesses.containsKey(day))
					tastinesses.put(day, temptastiness);

				
			}
			ArrayList<Integer> tastinessesValues = new ArrayList<Integer>(tastinesses.values());
			// System.out.println(tastinesses);
			int max = Collections.max(tastinessesValues);
			tastinessesValues.remove(new Integer(max));
			int nextmax = Collections.max(tastinessesValues);
			System.out.println(max+nextmax);
		}
	}
}