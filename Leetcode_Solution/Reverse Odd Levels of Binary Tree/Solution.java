class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        List<ArrayList<Integer>> list=new ArrayList();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        int level=0;
         ArrayList<Integer> l=new ArrayList<Integer>();
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp==null)
            {
                list.add(l);
                if(q.size()>0)
                {
                    l=new ArrayList<Integer>();
                    q.add(null);
                    level++;
                }
            }
            else
            {
                    l.add(temp.val);
                    if(temp.left!=null)
                    {
                        q.add(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        q.add(temp.right);
                    }
            }
        }
        
        q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        level=0;
        int i=list.get(0).size()-1;
        ArrayList<Integer> al=new ArrayList<Integer>();
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp==null)
            {
                list.add(l);
                if(q.size()>0)
                {
                    q.add(null);
                    level++;
                    if(level%2!=0)
                    {
                        al=list.get(level);
                        i=al.size()-1;
                    }
                }
            }
            else
            {
                  if(level%2!=0)
                  {
                      temp.val=al.get(i);
                      i--;
                  }
                    if(temp.left!=null)
                    {
                        q.add(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        q.add(temp.right);
                    }
            }
        }
        
        return root;
    }
}
