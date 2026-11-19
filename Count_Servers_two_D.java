import java.util.*;
import java.io.*;
public class Count_Servers_two_D {

    public static int[] rowCount(int[][] grid, int m, int n){
        int[] countRow = new int[m];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                    countRow[i]++;
            }
        }
        // for(int i=0;i<m;i++) System.out.print(countRow[i]+" ");
        return countRow;
    }

    public static int[] columnCount(int[][] grid, int m, int n)
    {
        int[] countCol = new int[n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1) countCol[j]++;
            }
        }
        // for(int i=0;i<n;i++) System.out.print(countCol[i]+" ");
        return countCol;
    }

    public static int countServer(int[][] grid, int m, int n){
        int[] row = rowCount(grid, m, n);
        int[] col = columnCount(grid, m, n);
        int count=0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    if(row[i] > 1 || col[j] > 1)
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line==null) return;

        String[] size = line.trim().split("\\s+");
        int m = Integer.parseInt(size[0].trim());
        int n = Integer.parseInt(size[1].trim());

        int[][] grid = new int[m][n];
        for(int i=0; i<m; i++)
        {
            String[] input = br.readLine().trim().split("\\s+");
            for(int j=0; j<n; j++)
            {
                grid[i][j] = Integer.parseInt(input[j]);
            }
        }
        // rowCount(grid, m, n);
        // System.out.println();
        // columnCount(grid, m, n);
        // System.out.println();
        System.out.print(countServer(grid, m, n));
    }
    
}
