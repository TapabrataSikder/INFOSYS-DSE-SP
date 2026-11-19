import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_Climbing_Stairs {

    public static int uniqueStairs(int n){
        if(n==1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for(int i=2; i<n; i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return(dp[n-1]);

    }

    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line==null) return;
        int n = Integer.parseInt(line.trim());
        System.out.print(uniqueStairs(n));
    }
}