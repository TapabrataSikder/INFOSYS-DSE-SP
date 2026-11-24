// Remove Duplicates from Sorted Array
import java.util.*;
import java.io.*;

public class Two_pointer_Remove_Duplicate {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        String[] input = line.trim().split("\\s+");
        int n = Integer.parseInt(input[0].trim());
        String[] arr=br.readLine().trim().split("\\s+");
        int nums[] = new int[arr.length];
        for(int i=0;i<n;i++) nums[i] = Integer.parseInt(arr[i]);

        int slow= 0;
        for(int fast=0;fast<n;fast++){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        int k = slow+1;
        System.out.print(k+"\n");
        for(int i=0;i<k;i++)
        {
            System.out.print(nums[i]);
            if(i<k-1) System.out.print(" ");
        }
    }
}

