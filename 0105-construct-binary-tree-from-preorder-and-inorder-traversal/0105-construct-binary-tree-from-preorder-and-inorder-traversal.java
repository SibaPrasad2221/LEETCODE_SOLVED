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
    //TC: O(N^2), SC: O(H)
	    public static TreeNode ConstructTree(int []inorder,int in_st,int in_end,int []preorder,int pre_st,int pre_end,HashMap<Integer,Integer> map){
        
        if(pre_st > pre_end || in_st > in_end) return null; //if st index crosses en index
        
        TreeNode root = new TreeNode(preorder[pre_st]);
        
        int in_root = map.get(root.val); //it will store the root index from inorder traversal 
        
        int nums_left = in_root - in_st; //no of elements in the left side is the left sub tree for that node
        
        
        root.left = ConstructTree(inorder, in_st, in_root-1, preorder, pre_st+1, pre_st+nums_left, map);
        
        root.right =ConstructTree(inorder, in_root+1, in_end, preorder, pre_st+nums_left+1, pre_end, map);
        
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hmap = new HashMap<>();//store value vs index from inorder aray
        
        for(int i=0;i<inorder.length;i++){
            hmap.put(inorder[i], i);
        }
        
        
        TreeNode root = ConstructTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, hmap);
        
        return root;
    }
}