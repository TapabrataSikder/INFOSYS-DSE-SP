// You are given two integers, N and K. Your task is to count the total number of integer arrays of length K that satisfy the following conditions: 
// 1. Range Constraint: Every element a[i] in the array is within the range [1, N] (i.e., 1 ≤ a[i] ≤ N). 
// 2. Strictly Increasing & Distinct: All elements in the array must be unique-no number can be repeated (a[i] < a[i + 1]). 
// 3. Divisibility Constraint: For every pair of consecutive elements, the next element must be strictly divisible by the previous 
// element: a[i+1] (mod a[i]) == 0 (for all valid indices 0 ≤ i<K-1). 
// Since the total count can be very large, return the result modulo 10000. 
// Input Format The first and only line contains two space-separated integers, N and K.

import java.util.*;
import java.io.*;

public class dp_subarray {

    static final int MOD = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String[] input = br.readLine().trim().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] dp = new int[k + 1][n + 1];

        // Base condition
        for (int num = 1; num <= n; num++) {
            dp[1][num] = 1;
        }

        // DP transition
        for (int len = 2; len <= k; len++) {
            for (int num = 1; num <= n; num++) {
                // Find proper divisors
                for (int d = 1; d * d <= num; d++) {
                    if (num % d == 0) {
                        // First divisor
                        if (d < num) {
                            dp[len][num] =
                                (dp[len][num] + dp[len - 1][d]) % MOD;
                        }
                        // Paired divisor
                        int paired_d = num / d;
                        if (paired_d != d && paired_d < num) {
                            dp[len][num] = (dp[len][num] + dp[len - 1][paired_d]) % MOD;
                        }
                    }
                }
            }
        }

        // Calculate final answer
        int ans = 0;
        for (int num = 1; num <= n; num++) {
            ans = (ans + dp[k][num]) % MOD;
        }
        System.out.println(ans);
    }
}

