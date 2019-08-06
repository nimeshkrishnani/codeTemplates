import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	void swap(String [] s, int i, int j)
	{
		String temp = s[i];
		s[i] = s[j];
		s[j] = temp;
		return;
	}
	String [] reverser(String [] s)
	{
		for(int i=0;i<s.length/2;i++)
			swap(s, i, s.length-i-1);
		return s;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Codechef c = new Codechef();
		int tests = Integer.parseInt(br1.readLine());
		for(int t=0;t<tests;t++)
		{
			String [] inp = br1.readLine().split("");
			int n = inp.length;
			String [] revInp = inp.clone();
			c.reverser(revInp);
			int count = 0;
			lcs
		}
	}
}