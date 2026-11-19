import java.util.*;
import java.io.*;

public class Greedy_Coin_change {

    public static void Change(int v){
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int n=coins.length;
        int count=0;

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=n-1; i>=0; i--)
        {
            while(v >= coins[i])
            {
                v=v-coins[i];
                result.add(coins[i]);
                count++;
            }
        }
        for(int coin : result){
            System.out.print(coin+" ");
        }
        System.out.print("\n"+count);
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line==null) return;
        int v = Integer.parseInt(line.trim());

        Change(v);
    }
}
