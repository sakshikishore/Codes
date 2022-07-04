class CBTInserter {
    TreeNode t=null;
    int ans=-1;
    public CBTInserter(TreeNode root) {
        t=root;
    }
    
    public int insert(int val) {
       TreeNode ptr=new TreeNode(val,null,null);
       if(t==null)
       {
           t=ptr;
       }
       else
       {
           Queue<TreeNode> q=new LinkedList<TreeNode>();
           q.add(t);
           while(q.size()>0)
           {
               TreeNode temp=q.poll();
               if(temp.left==null)
               {
                   ans=temp.val;
                   temp.left=ptr;
                   break;
               }
               else
               {
                   q.add(temp.left);
               }
               if(temp.right==null)
               {
                   ans=temp.val;
                   temp.right=ptr;
                   break;
               }
               else
               {
                   q.add(temp.right);
               }
           }
       }
        
        return ans;
    }
    
    public TreeNode get_root() {
        return t;
    }
}
