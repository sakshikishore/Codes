class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> l=new ArrayList<Integer>();
        int sum=0;
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp!=null)
            {
                sum+=temp.val;
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
            else
            {
                l.add(sum);
                System.out.println(sum);
                if(q.size()>0)
                {
                    q.add(null);
                    sum=0;
                }
            }
        }
        q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        int i=0;
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp!=null)
            {
                if(i==0 || i==1)
                {
                    temp.val=0;
                }
                if(temp.left!=null && temp.right!=null)
                {
                     if(i!=0)
                     {
                         sum=l.get(i+1);
                         int p=temp.left.val+temp.right.val;
                         temp.left.val=sum-p;
                         temp.right.val=sum-p;
                     }
                    q.add(temp.left);
                    q.add(temp.right);
                }
                else if(temp.left!=null)
                {
                    if(i!=0)
                     {
                         sum=l.get(i+1);
                         int p=temp.left.val;
                         temp.left.val=sum-p;
                     }
                    q.add(temp.left);
                }
                else if(temp.right!=null)
                {
                    if(i!=0)
                     {
                         sum=l.get(i+1);
                         int p=temp.right.val;
                         temp.right.val=sum-p;
                     }
                    q.add(temp.right);
                }
            }
            else
            {
                if(q.size()!=0)
                {
                    q.add(null);
                    i++;
                }
            }
        }
        
        return root;
    }
}
