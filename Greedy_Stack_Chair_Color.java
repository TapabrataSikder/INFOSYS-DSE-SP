import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Greedy_Stack_Chair_Color {
    public static int minStack(int[] arr, int h){
        for(int i=0;i<arr.length;i++){
            
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        if(line==null) return;
        String[] input=line.trim().split("\\s+");
        int[] arr = new int[input.length];
        for(int i=0; i<input.length; i++)
        {
            arr[i] = Integer.parseInt(input[i]);
        }
        String[] h=br.readLine().trim().split("\\s+");
        int H = Integer.parseInt(h[0]);
        System.out.print(minStack(arr, H));
    }
}
