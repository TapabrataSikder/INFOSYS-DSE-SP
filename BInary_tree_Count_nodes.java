import java.util.*;
import java.io.*;

// Create a TreeNode class
class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int val){
        this.val=val;
    }
}
public class BInary_tree_Count_nodes {

    // Build Complete BIn Tree
    public static TreeNode buildTree(int[] num, int i){
        if(i >= num.length) return null;

        TreeNode root = new TreeNode(num[i]);
        root.left = buildTree(num, 2*i+1);
        root.right = buildTree(num, 2*i+2);
        return root;
    }

    // Left depth
    public static int leftDepth(TreeNode root){
        int depth=0;
        while(root != null){
            root = root.left;
            depth++;
        }
        return depth;
    }

    //Right depth
    public static int rightDepth(TreeNode root)
    {
        int d=0;
        while(root != null)
        {
            root = root.right;
            d++;
        }
        return d;
    }

    public static int countNode(TreeNode root){
        if(root == null) return 0;
        int left = leftDepth(root);
        int right = rightDepth(root);

        if(left==right){
            return (int) Math.pow(2, left) - 1;
        }

        return 1 + countNode(root.left) + countNode(root.right);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line= br.readLine();
        String[] input = line.trim().split("\\s+");
        int nums[] =new int[input.length];
        for(int i=0; i<input.length; i++)
        {
            nums[i] = Integer.parseInt(input[i]);
        }

        TreeNode root = buildTree(nums, 0);
        System.out.print(countNode(root));

    }
}
