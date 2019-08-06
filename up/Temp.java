import java.io.*;
import java.util.*;


public class Temp{
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		for(int t=0;t<tests;t++)
		{
		int k = t;
		//String inp[] = br.readLine().split(" ");
		int n = (int)((Math.ceil((Math.log(k)/Math.log(2)))));
		int a[] = new int[n+1];
		// for(int i=0;i<=n;i++){
		// 	a[i] = (int)Math.pow(2,i);
		// 	System.out.print(a[i]+" ");
		// }
		// System.out.println();
		int dp[] = new int[k+1];
		dp[0]=1;
		Arrays.fill(dp,1);
		for(int j=1;j<=n;j++){
			for(int i=1;i<=k;i++){
				if(a[j]<=i){
					dp[i] = dp[i] + dp[i-a[j]];
				}
			}
		}
		System.out.println("for "+k+" "+dp[k]);
	}
	}
}