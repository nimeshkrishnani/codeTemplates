 import java.lang.*;
import java.util.*;
import java.io.*;

class Codechef
{
    public static BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    int atoi(String str)
    {
        String arr[] = str.split("");
        int out = 0;
        boolean negative = false;
        if(arr[0].equals("-"))
        {
            negative = true;
        }
        HashMap<String,Integer> digits = new HashMap<String,Integer>();
        String [] digitstr = "0123456789".split("");
        for(int i=0;i<10;i++)
            digits.put(digitstr[i],i);
        if(!negative)
            for(int i=0;i<arr.length;i++)
                if(digits.containsKey(arr[i]))
                    out = out*10 + digits.get(arr[i]);
                else
                {
                    return -1;
                }
        else
            for(int i=1;i<arr.length;i++)
                if(digits.containsKey(arr[i]))
                    out = out*10 + digits.get(arr[i]);
                else
                {
                    return -1;
                }
        if(negative)
        out = out*-1;
        return out;
    // Your code here
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        String numTestString = br1.readLine();
        int numTest= Integer.parseInt(numTestString);
        // System.out.println("number of tests are "+numTest);
        String [] temp;
        for(int t=0;t<numTest;t++)
        {
            Codechef c = new Codechef();
            System.out.println(c.atoi(br1.readLine()));
        }
    }
}

