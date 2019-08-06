import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	public static int max(int a, int b)
	{
		if(a>=b)
			return a;
		else
			return b;
	} 
	public static int min(int a, int b)
	{
		if(a>b)
			return b;
		else
			return a;
	} 

	public static void main (String[] args) throws java.lang.Exception
	{
		String temp = br1.readLine();
		String [] temparr;
		ArrayList<String> arr;
		int swaps, left, right, swapforleft, swapforright, leftswapdistance = 0, rightswapdistance = 0;
		boolean leftpossible = true, rightpossible = true, impossible = false;
		while(!temp.equals("0"))
		{
			temparr = temp.split("");
			arr = new ArrayList<String>();
			for(int k=0;k<temparr.length;k++)
				arr.add(temparr[k]);
			swaps = 0;
			left=0;
			right=arr.size()-1;
			System.out.println("string between "+left+" and "+right);
			while(right-left>=1)
			{
				if(arr.get(right).equals(arr.get(left)))
				{
					arr.remove(right);
					arr.remove(left);
					right = right - 2;
				}
				else
				{
					swapforleft = left + 1;
					swapforright = right - 1;
					while(swapforleft<right&&!arr.get(right).equals(arr.get(swapforleft)))
						swapforleft++;
					while(swapforright>left&&!arr.get(left).equals(arr.get(swapforright)))
						swapforright--;
					System.out.println("found match for left extreme "+arr.get(left)+" at "+swapforright);
					System.out.println("found match for right extreme "+arr.get(right)+" at "+swapforleft);
					if(swapforright==left)
						leftpossible = false;
					if(swapforleft==right)
						rightpossible = false;
					System.out.println("left possible "+leftpossible+" rightpossible "+rightpossible);
					leftswapdistance = swapforright - left;
					rightswapdistance = right - swapforleft;
					System.out.println("left swap distance "+leftswapdistance+" right swap distance"+rightswapdistance);
					if(leftpossible&&rightpossible)
					{
						if(leftswapdistance>rightswapdistance)
						{
							swaps += rightswapdistance;
							System.out.println("removing "+arr.get(swapforright)+" and "+arr.get(left));
							arr.remove(swapforright);
							arr.remove(left);
							right = right - 2;
						}
						else
						{
							swaps += leftswapdistance;
							System.out.println("removing "+arr.get(swapforleft)+" and "+arr.get(right));
							arr.remove(right);
							arr.remove(swapforleft);
							right = right - 2;
						}
					}
					else
						if(leftpossible)
						{
							swaps += leftswapdistance;
							System.out.println("removing "+arr.get(swapforright)+" and "+arr.get(left));
							arr.remove(swapforright);
							arr.remove(left);
							right = right - 2;
						}
						else
						{
							swaps += rightswapdistance;
							arr.remove(right);
							arr.remove(swapforright);
							right = right - 2;
						}
					if(!leftpossible&&!rightpossible)
					{
						impossible=true;
						break;
					}
				}
			}
			if(impossible)
				System.out.println("impossible");
			else
				System.out.println(swaps);
			temp = br1.readLine();
		}
		return;
	}
}