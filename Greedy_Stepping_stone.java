// # The Stepping Stones of Destiny

// ### The Legend (Problem Statement)

// You are a daring adventurer attempting to cross a treacherous, roaring river. Scattered across the water is a sequence of magical stepping stones. You start on the very first stone. Each stone is imbued with a jumping spell, represented by an integer, which dictates the absolute maximum number of stones you can leap forward from that spot.

// Your ultimate goal is to determine if you possess the magical momentum to reach the final stepping stone on the opposite riverbank. Return true if you can make it across safely, or false if you are doomed to be stranded mid-river.

// Example 1:

// * Input: stones (nums) = [2, 3, 1, 1, 4]
// * Output: true
// * Explanation: Leap 1 step from stone 0 to stone 1, then take a massive 3-step leap straight to the final stone.

// Example 2:

// * Input: stones (nums) = [3, 2, 1, 0, 4]
// * Output: false
// * Explanation: You will inevitably get stuck on stone 3. Its jumping spell has a power of 0, 
// meaining you can never leap any further.

import java.util.*;
import java.io.*;

public class Greedy_Stepping_stone {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line= br.readLine();
        if(line==null) return;
        String[] input = line.trim().split(",");
        int[] nums = new int[input.length];
        for(int i=0; i<input.length; i++){
            nums[i] = Integer.parseInt(input[i].trim());
        }
        int finalPosition = nums.length-1;
        for(int i=nums.length-2; i>=0; i--)
        {
            if(i+nums[i] >= finalPosition)
            {
                finalPosition = i;
            }
        }
        if(finalPosition == 0){
            System.out.print("true");
        }
        else System.out.print("false");

    }
}
