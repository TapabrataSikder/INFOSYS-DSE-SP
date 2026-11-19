// Problem Statement A staircase contains N steps numbered from 1 to N. 
// You start from step 1 and want to reach step N. From any step, you may jump only 
// to the next Fibonacci step ahead. 
// That is, if you are currently on step i, you may move to: 
// i+1 
// i+2 
// i+3 
// i+5 
// i+8

// Input: 
// N A B
// 10 5 2
// Output:
// 28

import java.util.Scanner;

class fibonacci_jump_dp{

    // static int disp(int n, int a, int b){
        
        

    // }

    public static void main(String argsp[]){
        Scanner sc = new Scanner(System.in);
        String input[] = sc.nextLine().trim().split(" ");
        int num[] = new int[input.length];
        for(int i=0; i<input.length; i++){
            num[i] = Integer.parseInt(input[i].trim());
        }

        // System.out.print(disp(num[0], num[1], num[2]));
        sc.close();
    }
}