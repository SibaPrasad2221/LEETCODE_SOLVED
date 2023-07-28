//{ Driver Code Starts
//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution g = new Solution();
    	        ArrayList<Integer> nodes = g.ExtremeNode(root);
    	        for(int i = 0;i<nodes.size();i++){
    	            System.out.print(nodes.get(i)+ " ");
    	        }
    	        System.out.println();
	        }
	}
}

// } Driver Code Ends


/*Complete The given function
The Node class is as follows:
class Node{
    int data;
    Node left,right;
    
    Node(int d)
     {
      data=d;
      left=null;
      right=null;
    }
}*/
class Solution{
    public  ArrayList<Integer> ExtremeNode(Node root)
      {
        //add code here.
        if(root==null) return new ArrayList<>();//base condition
        
        
        Queue<Node> q = new LinkedList<>();
        
        // ArrayList<Integer> res = new ArrayList<>();
        
        ArrayList<Integer> res= new ArrayList<>();
        
        q.add(root);
        
        
        //peform level order travsersal
        
        boolean found = false;
        while(q.size()!=0){
            int size=q.size();
            
            
            for(int i=0;i<size;i++){
                Node curr = q.remove(); //removing last added element
                
                
                if(found){ 
                    if(i==0) res.add(curr.data);
                }else{
                    if(i==size-1) res.add(curr.data); 
                }
                
                
                if(curr.left !=null){//if it has left child add it to the queue
                    q.add(curr.left);
                }
                
                if(curr.right !=null){ //if it has add it travsersal
                    q.add(curr.right);
                }
            }
            found=!found;
        }
        
        return res;
      }
}