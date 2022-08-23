class Solution {
    String result="";
    public String tree2str(TreeNode root) {
        if(root==null)
        {
            return result;
        }
        result=result+Integer.toString(root.val);
        if(root.left==null && root.right==null)
        {
            return result;
        }
        else
        {
            result=result+"(";
            tree2str(root.left);
            result=result+")";
            if(root.right!=null)
            {
                result=result+"(";
                tree2str(root.right);
                result=result+")";
            }
        }
        
        return result;
    }
}
