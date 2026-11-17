// Sort array without built in functions 
// using 3-pointer

import java.util.Scanner;
import java.util.Arrays;
class DutchAlgo{

    static int[] dutchAlgo(int[] a){
        int start=0;
        int mid=0;
        int end = a.length - 1;

        while(mid <= end){
            if(a[mid] == 0){
                int temp=a[start];
                a[start] =a[mid];
                a[mid]=temp;
                start++;
                mid++;
            }
            else if(a[mid] == 2){
                int temp=a[end];
                a[end] = a[mid];
                a[mid]=temp;
                end--;
            }
            else if(a[mid] == 1){
                mid += 1;
            }
        }
        return a;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String input[] = sc.nextLine().trim().split(",");
        int[] a = new int[input.length];
        for(int i=0; i<input.length; i++){
            a[i]=Integer.parseInt(input[i].trim());
        }

        int[] res = dutchAlgo(a);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
}