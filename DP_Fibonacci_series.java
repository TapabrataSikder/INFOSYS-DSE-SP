import java.util.*;
import java.io.*;

class DP_Fibonacci_series{

    public static void fibo(int n){
        int[] dp= new int[n];
        dp[0] =1;
        dp[1] =1;
        for(int i=2;i<n;i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        for(int c : dp){
            System.out.print(c + " ");
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        if(line==null) return;
        int n=Integer.parseInt(line.trim());
        fibo(n);
    }
}