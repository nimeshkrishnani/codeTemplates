import java.io.*;
import java.util.*;


public class Kemp{
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		//String inp[] = br.readLine().split(" ");
		int n = (int)((Math.ceil((Math.log(k)/Math.log(2)))));
		int a[] = new int[n+1];
		for(int i=0;i<=n;i++){
			a[i] = (int)Math.pow(2,i);
			System.out.print(a[i]+" ");
		}
		System.out.println();
		int dp[] = new int[k+1];
		dp[0]=0;
			for(int j=0;j<=k;j++)
				dp[j]=1;
			// 	System.out.print(dp[j]+" ");
			// System.out.println();
		for(int i=2;i<=k;i++)
		{
			for(int j=a[i]+1;j<=k;j++)
			{
				dp[j]+=dp[j-a[i]];
			}
			for(int j=0;j<=k;j++){
				System.out.print(dp[j]+" ");
			}
			System.out.println();
		}
		System.out.println(dp[k]);
	}
}