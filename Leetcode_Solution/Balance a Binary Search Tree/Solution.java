class Solution {
    ArrayList<Integer> l=new ArrayList<Integer>();
    public void InOrder(TreeNode root)
    {
        if(root!=null)
        {
            InOrder(root.left);
            l.add(root.val);
            InOrder(root.right);
        }
    }
    public TreeNode InsertBST(ArrayList<Integer> l,int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        
            int mid=(start+end)/2;
            TreeNode head=new TreeNode(l.get(mid),null,null);
            head.left=InsertBST(l,start,mid-1);
            head.right=InsertBST(l,mid+1,end);
        
        return head;
    }
    public TreeNode balanceBST(TreeNode root) {
       InOrder(root);
       return InsertBST(l,0,l.size()-1);
        
    }
}
