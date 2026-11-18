// 2-pointer Sorted GREEDY
import java.util.*;
import java.io.*;

public class rescue_boat {
    static int[] sortArray(int[] nums){
        for(int i=0;i<nums.length-1; i++){
            for(int j=0; j<nums.length-i-1; j++)
            {
                if(nums[j] > nums[j+1]){
                    int temp=nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }

    static int minRescueBoat(int[] people, int limit){
        people = sortArray(people);
        int boats=0;
        int left = 0;
        int right = people.length-1;
        
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left += 1;;
            }
            else{
                right -=1;
                boats +=1;
            }
        }
        return boats;
    }
    
    public static void main(String[] args ) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line == null) return;

        String[] input = line.trim().split("\\s+");
        int[] people = new int[input.length];

        for(int i=0; i<input.length;i++){
            people[i] = Integer.parseInt(input[i]);
        }
        int limit = Integer.parseInt(br.readLine().trim());

        // System.out.println(Arrays.toString(sortArray(people)));
        // System.out.print(limit);
        System.out.print(minRescueBoat(people, limit));
    }
}
