// You are a Master Alchemist entrusted with an ancient spellbook. Your task is to transmute a base magical 
// incantation (word1) into a perfect, powerful spell (word2).

// To alter the incantations, you are permitted to use three fundamental alchemical operations, 
// each costing exactly one unit of mystical energy (mana):

// 1. Insert a magical rune (character)
// 2. Delete a magical rune
// 3. Replace a magical rune

// Your goal is to calculate the minimum total mana (operations) required to perfectly convert 
// the base incantation into the target spell.

// Example 1:

// * Input: word1 = "horse", word2 = "ros"
// * Output: 3
// * Explanation:
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')

import java.io.*;

public class DP_tring_Alchemist_Transmutation {
    public static int minOper(String w1, String w2){
        w1=w1.toLowerCase();
        w2=w2.toLowerCase();
        int m=w1.length();
        int n=w2.length();

        int[][] dp =new int[m+1][n+1];

        // Initialize DP
        for(int i=1; i<=m; i++) dp[i][0] = i;
        for(int j=1; j<=n; j++) dp[0][j] = j;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(w1.charAt(i-1) == w2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    int left = dp[i][j-1];
                    int top = dp[i-1][j];
                    int d = dp[i-1][j-1];
                    dp[i][j] = Math.min(left, Math.min(top, d))+1;
                }
            }
        }


        return dp[m][n];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        if(line==null) return;
        String[] input = line.trim().split("\\s+");
        String w1 =input[0];
        String w2 = input[1];
        System.out.print(minOper(w1, w2));
    }
}
