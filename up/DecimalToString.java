	import java.util.*;
	import java.lang.*;
	import java.io.*;
	import java.math.BigDecimal;

	class DecimalToString
	{
		public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

		public static void main (String[] args) throws java.lang.Exception
		{
			System.out.print("Please input A and B ");
			String [] inp = br1.readLine().split(" ");
			long a = Long.parseLong(inp[0]);
			long b = Long.parseLong(inp[1]);
			StringBuilder res = new StringBuilder();
			// String resWithBrackets = new String;
			long currentPos = 0;
			HashMap<Long, Long> nonRepresentableChecker = new HashMap<Long, Long>();
			res.append(String.valueOf(a/b));
			if(a%b!=0)
			{
				res.append(".");
				int decimalAfter = res.length();
				System.out.println("found decimal after "+decimalAfter);
				while((!nonRepresentableChecker.containsKey(((a%b)*10)/b))&&a!=0)
				{
					System.out.println(nonRepresentableChecker.containsKey(((a%b)*10)/b));
					nonRepresentableChecker.put(((a%b)*10)/b, currentPos);
					System.out.println(nonRepresentableChecker);
					System.out.println(nonRepresentableChecker.containsKey(((a%b)*10)/b));
					System.out.println("adding "+String.valueOf((a%b)*10/b));
	 				currentPos++;
					res.append(String.valueOf((a%b)*10/b));
					a = ((a%b)*10)%b;
				}
				// System.out.println("found key already present as "+(((a%b)*10)/b));
				if(a!=0)
				{
					res.insert((int)(decimalAfter+nonRepresentableChecker.get(((a%b)*10)/b)), '(');
					res.insert(res.length(), ')');
				}
			}
		    // System.out.println("number of tests are "+numTest);
				System.out.println(res);
				// System.out.println((long)10.00);
		}
	}