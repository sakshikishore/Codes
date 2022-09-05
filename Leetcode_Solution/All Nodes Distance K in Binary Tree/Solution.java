class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       ArrayList<Integer> result=new ArrayList<Integer>();
       HashMap<TreeNode,TreeNode> childParent=new HashMap<TreeNode,TreeNode>();
       Queue<TreeNode> q=new LinkedList<TreeNode>();
       q.add(root);
       while(q.size()>0)
       {
           TreeNode temp=q.poll();
           if(temp.left!=null)
           {
               q.add(temp.left);
               childParent.put(temp.left,temp);
           }
           if(temp.right!=null)
           {
               q.add(temp.right);
               childParent.put(temp.right,temp);
           }
       }
       HashMap<TreeNode,Integer> distance=new HashMap<TreeNode,Integer>();
       q=new LinkedList<TreeNode>();
       distance.put(target,0);
        q.add(target);
        HashSet<TreeNode> h=new HashSet<TreeNode>();
        h.add(target);
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            int dist=distance.get(temp);
            if(dist==k)
            {
                result.add(temp.val);
            }
            else
            {
                if( childParent.containsKey(temp))
                {
                    TreeNode parent= childParent.get(temp);
                    if(!h.contains(parent))
                    {
                        h.add(parent);
                        q.add(parent);
                        distance.put(parent,dist+1);
                    }
                }
                if(temp.left!=null)
                {
                    if(!h.contains(temp.left))
                    {
                        q.add(temp.left);
                        distance.put(temp.left,dist+1);
                        h.add(temp.left);
                    }
                }
                if(temp.right!=null)
                {
                     if(!h.contains(temp.right))
                    {
                        q.add(temp.right);
                        distance.put(temp.right,dist+1);
                        h.add(temp.right);
                    }
                }
            }
        }
        
        
        return result;
    }
}
