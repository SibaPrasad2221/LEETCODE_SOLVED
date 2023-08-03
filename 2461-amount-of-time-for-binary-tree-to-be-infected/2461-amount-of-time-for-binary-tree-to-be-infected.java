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

    //this will generate child->parent hashmap
    //TC: O(N) to create the hashmap
    public static void traversal(TreeNode root, HashMap<TreeNode, TreeNode> map){
        if(root == null){
            return ;
        }
        
        //if root has left child
        if(root.left != null) map.put(root.left,root);
        
        //if root has a right child
        if(root.right != null) map.put(root.right,root);
        
        //now explore left substree and right subtree;
        traversal(root.left, map);
        traversal(root.right, map);

    }
    
    
    //fidn the node for the target
    public static TreeNode find(TreeNode root, int target){
        if(root == null){
            return null;
        }
        if(root.val == target) return root;
        
        TreeNode foundinLeftChild = find(root.left, target);
        if(foundinLeftChild != null){
            return foundinLeftChild;
        }
        
        TreeNode foundinRightChild = find(root.right, target);
        if(foundinRightChild != null){
            return foundinRightChild;
        }
        
        return null;
        
    }

    //TC: O(N), SC: O(N)
    public int amountOfTime(TreeNode root, int target) {
        //it will store child -> parents
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        traversal(root, map);
        
        TreeNode target_Node = find(root, target);
        
        if(target_Node == null) return 0; //if there is no buring tree
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(target_Node);
        
        
        //we will created a visited hashset which can check which all node has already been visited and marked them as true
        //if we won;t check or create hashset, then eg if 2 burn 5 then 5 burn 2 again 2 burn 5 and 5 burn 2 and infinity loop so to overcome 
        //we need hashset which will work as visited node status and search the visited node status at o(1)
        
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target_Node);
        
        int level =0;
        
        while(que.size() > 0){
            int size = que.size();
            while(size-->0){
                TreeNode rnode = que.remove();
                
                if(rnode.left != null && visited.contains(rnode.left)==false){
                    // does it have a left child and && is it node burned till now
                    que.add(rnode.left); //burn it 
                    visited.add(rnode.left); //and mark it visited
                }
                
                if(rnode.right != null && visited.contains(rnode.right)==false){
                    // does it have a right child and && is it node burned till now
                    que.add(rnode.right);
                    visited.add(rnode.right);
                }  
                
                if(map.containsKey(rnode) ==true && visited.contains(map.get(rnode))==false){ 
                    //does it have parents and if it's not burned
                    que.add(map.get(rnode));
                    visited.add(map.get(rnode));
                }
            }
            level++;
        }
        
        if(level == 0){
            return 0;
        }
        
        return level-1; 
        //we actually counting level first then going to that level suppose we are doing operation for level 5 it should be level 4 actually becuz of zero based index so level -1 i sthe time required
    }
}