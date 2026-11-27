// n -> no of steps
// cost[i] -> cost at i-th step
// calculate min cost to reach top; start form either 0 or 1

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_min_cost_climb_stair {
    public static int minCost(int n , int[] cost){
        int[] dp = new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++)
        {
            dp[i]=cost[i]+Math.min(dp[i-1], dp[i-2]);
        }
        return (Math.min(dp[n-1], dp[n-2]));
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line==null) return;
        String[] input = line.trim().split("\\s+");
        int n = Integer.parseInt(input[0]);
        String[] nums = br.readLine().trim().split("\\s+");
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            cost[i] = Integer.parseInt(nums[i].trim());
        }
        System.out.print(minCost(n, cost));
    }
    
}
