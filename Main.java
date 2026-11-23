// Solution for: Matrix Addition
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        // Write your solution logic here
        String[] input = line.trim().split("\\s+");
        int n=Integer.parseInt(input[0]);
        int m=Integer.parseInt(input[1]);

        int[][] a=new int[n][n];
        int[][] b=new int[m][m];

        for(int i=0;i<n;i++)
        {
            String[] row = br.readLine().trim().split("\\s+");
            for(int j=0;j<m;j++)
            {
                a[i][j] = Integer.parseInt(row[j]);
                
            }
        }
        for(int i=0;i<m;i++)
        {
            String[] row = br.readLine().trim().split("\\s+");
            for(int j=0;j<m;j++)
            {
                b[i][j] = Integer.parseInt(row[j]);
            }
        }
        int[][] res = new int[n][m];
        // int sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(res[i][j]);
                if(j<m-1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
