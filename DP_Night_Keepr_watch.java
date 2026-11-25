// PROBLEM DESCRIPTION:
// A keeper guards a post for N consecutive nights (0-indexed from 0 to N-1).
// On each night i, the keeper can either rest (earning 0 points) or stay alert (earning matrix[i][0] points). 
// You are given an N x 2 matrix where: 
// matrix[i][0] is the number of points earned if the keeper stays alert on night i 
// matrix[i][1] indicates the weather on night i: 1 if there is a storm, and 0 if it is safe. 

// The keeper must follow two rules: 
// 1. Storm Rule: If matrix[i][1] == 1, the keeper cannot rest on night i (they must stay alert). 
// 2. Fatigue Rule: In every W consecutive nights, the keeper must rest on at least one night 
// (Le, they cannot stay alert for W consecutive nights). 
// Return the maximum total points the keeper can earn over all N nights. 
// If it is impossible to satisfy both rules, return -1. 

// INPUT FORMAT First line contains two integers N and W. 
// Each of the next N lines contains two integers points[i] (matrix[i][0]) and storm[i] (matrix[i][1]).

// Input: 
// 4 3 
// 10 0 
// 20 1 
// 30 0 
// 40 0 
// Output:
// 70

// Explanation:
// Total points = 10 + 20 + 30 + 40 = 100. 
// Windows of size 3 are [0,1,2] and [1,2,3]. 
// Night 1 is a storm (1), so the keeper cannot rest there. 
// Resting on night 2 (sacrificing 30 points) covers both windows, leaving 100 - 30 = 70 points.

import java.util.*;
import java.io.*;

public class DP_Night_Keepr_watch{

    public static int maxPoint(int n, int w, int[][] matrix){
        int[] dp = new int[w];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for(int i=0; i<n; i++){
            int newdp[] = new int[w];
            Arrays.fill(newdp, Integer.MIN_VALUE);

            // Rest
            if(matrix[i][1] == 0)
            {
                int max=Integer.MIN_VALUE;
                for(int j=0; j<w; j++){
                    max = Math.max(max, dp[j]);
                }
                newdp[0] =max;
            }

            // Alert
            for(int j=0; j<w-1; j++){
                if(dp[j] != Integer.MIN_VALUE){
                    newdp[j+1] = dp[j] + matrix[i][0];
                }
            }
            dp=newdp;
        }
        int ans=Integer.MIN_VALUE;
        for(int j=0; j<w;j++)
        {
            ans=Math.max(ans, dp[j]);
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line==null) return;

        String[] input = line.trim().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);

        int [][] matrix = new int[n][2];
        for(int i=0; i<n;i++)
        {
            String[] arr = br.readLine().trim().split("\\s+");
            matrix[i][0] = Integer.parseInt(arr[0]); // points
            matrix[i][1] = Integer.parseInt(arr[1]); // storm
        }

        System.out.print(maxPoint(n, w, matrix));
    }
}