import java.util.*;
import java.io.*;

public class Greedy_Infinite_desert_journey {

    public static int index(int[] gas, int[] cost){
        int sumGas=0;
        int sumCost=0;
        for(int i=0;i<gas.length;i++)
        {
            sumGas += gas[i];
            sumCost += cost[i];
        } 

        if(sumGas < sumCost) return -1;
        int start=0, currentGas=0;
        
        for(int i=0;i<gas.length;i++){
            currentGas = gas[i] - cost[i];
            if(currentGas < 0)
            {
                start +=1;
                currentGas=0;
            }
        }
        return start;
        
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line==null) return;
        String[] gasInput = line.trim().split("\\s+");
        int[] gas = new int[gasInput.length];
        for(int i=0;i<gasInput.length;i++){
            gas[i] = Integer.parseInt(gasInput[i]);
        }

        String[] costInput = br.readLine().trim().split("\\s+");
        int[] cost = new int[costInput.length];
        for(int i=0;i<costInput.length;i++){
            cost[i] = Integer.parseInt(costInput[i]);
        }

        System.out.print(index(gas, cost));
    }
}
