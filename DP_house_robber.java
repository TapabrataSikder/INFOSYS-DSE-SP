// n -> no of houses
// house[i] -> houses
// max rob cost -> cant rob adjacent houses

// n=4
// house =[1, 2, 3, 1]
// o/p = 4 -> max(1+3, 2+1)

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_house_robber {
    public static int maxCost(int n, int[] house){
        int[] dp = new int[n];
        dp[0] = house[0];
        dp[1] = Math.max(house[0], house[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], house[i]+house[i-2]);
        }
        return dp[n-1];
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
        System.out.print(maxCost(n, cost));
    }
}