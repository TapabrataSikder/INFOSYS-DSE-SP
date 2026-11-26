// PROBLEM DESCRIPTION
// You are given N rooms (1 <= N <= 10^5) and an array litres of length N, where litres[i] is the 
// umber of litres of paint required to paint the i-th room. All required paint is pooled together, 
// so you need at least T = sum(litres[i]) litres in total.

// You can buy paint any number of times from two pack options:

// Single pack: costs a and provides 1 litre of paint.

// Bulk pack: costs b and provides S litres of paint.

// You may buy more litres than strictly needed if a bulk pack is cheaper overall. 
// Find the minimum total cost required to obtain at least T litres of paint.

// INPUT FORMAT
// First line contains four integers N, a, b, and S.
// Second line contains N space-separated integers representing the array litres.

// Input: 
// 3 4 10 3
// 2 1 2
// Output
// 18
// Explanation: Total needed T = 5 lt -> 1 bulk(3L, cost=10) + 2 single(2L, cost=8) = 18

import java.io.*;

public class Greedy_Painting_rooms {
    public static int minCost(int n, int a, int b, int s, int[] matrix){
        int T=0;        
        for(int i=0; i<n; i++){
            T += matrix[i];
        }
        if(b>=s*a) 
            return T*a;
        int bulkcost = T/s;
        int remainPack = T%s;
        int costAll = (bulkcost*b) + (remainPack*a);
        int extraBulkCost = (bulkcost+1)*b; 
        return Math.min(costAll, extraBulkCost);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        if(line==null) return;
        String[] input=line.trim().split("\\s+");
        int n=Integer.parseInt(input[0]);
        int a=Integer.parseInt(input[1]);
        int b=Integer.parseInt(input[2]);
        int s=Integer.parseInt(input[3]);
        int[] arr = new int[n];
        String litre[] = br.readLine().trim().split("\\s+");
        for(int i=0; i<n; i++)
        {
            arr[i] = Integer.parseInt(litre[i]);
        }
        System.out.print(minCost(n, a, b, s, arr));
    }
}
