
import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Binary_tree_complete {

    public static Node createTree(int[] arr){

        if(arr.length == 0) return null;

        Node root = new Node(arr[0]);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while(i < arr.length){

            Node current = q.poll();

            // Left Child
            if(i < arr.length){
                current.left = new Node(arr[i]);
                q.add(current.left);
                i++;
            }

            // Right Child
            if(i < arr.length){
                current.right = new Node(arr[i]);
                q.add(current.right);
                i++;
            }
        }

        return root;
    }

    // Inorder Traversal
    public static void inorder(Node root){

        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        String line = br.readLine();

        if(line == null || line.trim().isEmpty()) return;

        String[] input = line.trim().split("\\s+");

        int[] nums = new int[input.length];

        for(int i = 0; i < input.length; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        // Create Complete Binary Tree
        Node root = createTree(nums);

        // Print Inorder Traversal
        inorder(root);
    }
}
