class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.val==0)
        {
            return false;
        }
        if(root.val==1)
        {
            return true;
        }
        boolean left=evaluateTree(root.left);
        boolean right=evaluateTree(root.right);
        if(root.val==3)
        {
            return left && right;
        }
        else
        {
            return left || right;
        }
        
    }
}
