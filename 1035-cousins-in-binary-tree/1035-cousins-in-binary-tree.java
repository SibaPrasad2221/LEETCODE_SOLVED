class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> que = new LinkedList();

        que.offer(root);

        while(que.size() > 0){
            int size = que.size();
            boolean isXFound = false;
            boolean isYFound = false;

            for(int i =0;i<size;i++){
                TreeNode node = que.poll();
                if(node.left != null)que.offer(node.left);
                if(node.right != null)que.offer(node.right);

                if(node.val == x)isXFound = true;
                if(node.val == y)isYFound = true;


                if(node.left != null && node.right != null){
                    if((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x) ){
                        return false;
                    }
                }

            }
            if(isXFound && isYFound)return true;
        }
        return false;
        
    }

}