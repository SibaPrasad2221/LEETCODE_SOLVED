//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            int x = Integer.parseInt(br.readLine());
            Node root = buildTree(s);
            Tree g = new Tree();
            root = g.deleteNode(root, x);
            printInorder(root);
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Tree {
    // Function to delete a node from BST.
    public static int min(Node root){//find min in right 
			if(root.left ==null) return root.data;
			return min(root.left);
	}
    public static Node deleteNode(Node root, int val) {
        // code here.
        // WRITE YOUR CODE HERE
		if(root == null) return null;

		if(val > root.data){
			Node UpdatedRightRoot = deleteNode(root.right, val);
			root.right = UpdatedRightRoot;
		}else if(val < root.data ){
			Node UpdatedLeftRoot = deleteNode(root.left, val);
			root.left = UpdatedLeftRoot;
		}else{
			//if this the node i want to delete is equal to current node
			if(root.left == null && root.right == null){
				return null ;//if it's a leap node
			}
			else if(root.left !=null && root.right == null){//if it's only havving a left chidl eg 25 --> 30 -->27 and 30 we need to delete and 27 is the left of 30 then we can direectly connect 25 to 27
				//i am having only left child
				return root.left;
			}else if(root.left ==null && root.right != null){  //if it's only having right child
				return root.right;
			}else{
					//if the delete node having both right child and left child
			//either you choose largest from left substree or in right substree in  the root node postion and delete it;s previous position 
			//step:1 now search for maximum in left substree
			//step:2 put the value on node.val
			//step:3 delete node(node.left, val)
				int minVal = min(root.right);
				root.data = minVal;
				root.right = deleteNode(root.right, minVal);
			}
		}
		return root;
    }
}