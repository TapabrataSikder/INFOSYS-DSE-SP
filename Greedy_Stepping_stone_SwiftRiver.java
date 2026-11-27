// ### The Legend (Problem Statement)

// You are once again facing the treacherous river of magical stepping stones. 
// You know it's possible to cross, but this time, there is a catch: a fierce storm is approaching! 
// You must reach the final stone on the opposite bank using the absolute MINIMUM number of leaps to outrun the storm.

// You start on the first stone (index 0). The spell on each stone (nums[i]) tells you the maximum 
// number of stones you can leap forward from that spot. Your goal is to return the minimum number of jumps 
// required to reach the very last stone.

// Example 1:

// * Input: stones (nums) = [2, 3, 1, 1, 4]
// * Output: 2
// * Explanation: The minimal path requires only 2 jumps. Leap 1 step from stone 0 to stone 1, 
// and then take a massive 3-step leap

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Greedy_Stepping_stone_SwiftRiver {

    public static int minJumps(int[] nums){
        int coverage=0; 
        int totaljumps = 0;
        int lastJumpIdx = 0;
        int dest=nums.length-1;
        if(nums.length == 1) return 0;
        for(int i=0; i<nums.length; i++){
            coverage = Math.max(coverage, i+nums[i]);
            if(i == lastJumpIdx)
            {
                lastJumpIdx = coverage;
                totaljumps++;
                
                if(coverage >= dest){
                    return totaljumps;
                }
            }
            
        }
        return totaljumps;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line= br.readLine();
        if(line==null) return;
        String[] input = line.trim().split(",");
        int[] nums = new int[input.length];
        for(int i=0; i<input.length; i++){
            nums[i] = Integer.parseInt(input[i].trim());
        }
        System.out.print(minJumps(nums));
    }    
}
