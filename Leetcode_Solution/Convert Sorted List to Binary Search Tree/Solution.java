class Solution {
    public TreeNode insertBST(ArrayList<Integer> l,int start,int end){
        if(start>end)
        {
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(l.get(mid),null,null);
        root.left=insertBST(l,start,mid-1);
        root.right=insertBST(l,mid+1,end);
        
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(head!=null)
        {
            l.add(head.val);
            head=head.next;
        }
       return insertBST(l,0,l.size()-1);
    }
}
