import java.util.*;
import java.util.Scanner;

static class Max_length_longest_subarray{
    public int findLength(int[] nums1, int[] nums2){
        int max=0;
        int dp[][] = new int[nums1.length + 1][nums2.length + 1];

        for(int i=1; i<=nums1.length; i++){
            for(int j=1; j<=nums2.length; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;

    }
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    Max_length_longest_subarray obj = new Max_length_longest_subarray();
    
    String input1[] = sc.nextLine().trim().split(",");
    int nums1[] = new int[input1.length];
    for(int i=0; i<input1.length; i++){
        nums1[i] = Integer.parseInt(input1[i].trim());
    }
    String input2[] = sc.nextLine().trim().split(",");
    int nums2[] = new int[input2.length];
    for(int i=0; i<input2.length; i++){
        nums2[i] = Integer.parseInt(input2[i].trim());
    }
    System.out.println(obj.findLength(nums1, nums2));

    sc.close();
}