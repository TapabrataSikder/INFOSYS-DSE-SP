import java.util.Scanner;

public class maximumPairs{
    static int maxPairs(int[] a, int T){
        int[] count = new int[T];
        
        for(int x:a){
            count[x%T]++;
        }
        int ans = count[0]/2;

        // for(int i=1; i<=)

        if(T%2 == 0){
            ans += count[T/2]/2;
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().trim().split(",");
        int[] num = new int[input.length];
        for(int i=0; i<input.length; i++)
        {
            num[i] = Integer.parseInt(input[i].trim());
        }

        System.out.print(maxPairs(num, T));
        sc.close();
    }
}