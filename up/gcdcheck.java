import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
	static int gcd(int a, int b)
	{
        if(a<b)
	    return gcd(b,a);
	    if(a%b==0)
	    return b;
	    else
	    return gcd(b,a%b);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		for(int i=0;i<100000000;i++)
		{
			int a = (int) (Math.random()*100)+1;
			int c = (int) (Math.random()*100)+1;
			int d = (int) (Math.random()*100)+1;
			if(gcd(a*a,c*d)!=(gcd(a,c)*gcd(a,d)))
				System.out.println("false for "+a+" "+c+" "+d);
		}
		System.out.println("true");
		return;
	}
}
