import java.util.Scanner;

static class LongestRodPrice{
    public int cutrod(int[] price){
        int n=price.length;
        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i<=j){
                    int exclude = dp[i-1][j];
                    int include = price[i-1] + dp[i][j-i];
                    dp[i][j] = Math.max(exclude, include);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }

}

public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String[] input = sc.nextLine().trim().split(",");
    int[] price = new int[n];
    for(int i=0; i<n; i++){
        price[i]=Integer.parseInt(input[i].trim());
    }

    LongestRodPrice ob =new LongestRodPrice();
    System.out.print(ob.cutrod(price));

    sc.close();
}