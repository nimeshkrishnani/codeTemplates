/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static void call(int n)
	{
		try{
		call(n+1);
		}
		catch(StackOverflowError error){
			System.out.println("number of calls before stack overflow "+(n-1));
		}
		
	}
	public static void main (String[] args) 
	{
		// your code goes here
		call(0);
	}
}