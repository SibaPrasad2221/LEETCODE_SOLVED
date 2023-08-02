/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min(TreeNode root){//find min in right 
			if(root.left ==null) return root.val;
			return min(root.left);
	}
    public TreeNode deleteNode(TreeNode root, int val) {
        if(root == null) return null;

		if(val > root.val){
			TreeNode UpdatedRightRoot = deleteNode(root.right, val);
			root.right = UpdatedRightRoot;
		}else if(val < root.val ){
			TreeNode UpdatedLeftRoot = deleteNode(root.left, val);
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
				root.val = minVal;
				root.right = deleteNode(root.right, minVal);
			}
		}
		return root;
    }
}