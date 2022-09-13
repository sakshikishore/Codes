class Solution {
    public int longestZigZag(TreeNode root) {
         int max=0;
        try
        {
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            HashMap<TreeNode,ArrayList<Integer>> h=new HashMap<TreeNode,ArrayList<Integer>>();
            ArrayList<Integer> m=new ArrayList<Integer>();
            q.add(root);
            h.put(root,m);
            while(q.size()>0)
            {
                TreeNode temp=q.poll();
                ArrayList<Integer> l=h.get(temp);
                if(temp.left!=null)
                {
                    if(l.size()==0)
                    {
                        ArrayList<Integer> al=new ArrayList<Integer>();
                        al.add(1);
                        al.add(0);
                        if(1>max)
                        {
                            max=1;
                        }
                        h.put(temp.left,al);
                    }
                    else
                    {
                        if(l.get(1)==0)
                        {
                            ArrayList<Integer> al=new ArrayList<Integer>();
                            al.add(1);
                            al.add(0);
                            if(1>max)
                            {
                                max=1;
                            }
                            h.put(temp.left,al);
                        }
                        else
                        {
                            ArrayList<Integer> al=new ArrayList<Integer>();
                            al.add(l.get(0)+1);
                            al.add(0);
                            if(al.get(0)>max)
                            {
                                max=al.get(0);
                            }
                            h.put(temp.left,al);
                        }
                    }
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    if(l.size()==0)
                    {
                        ArrayList<Integer> al=new ArrayList<Integer>();
                        al.add(1);
                        al.add(1);
                        if(1>max)
                        {
                            max=1;
                        }
                        h.put(temp.right,al);
                    }
                    else
                    {
                        if(l.get(1)==1)
                        {
                            ArrayList<Integer> al=new ArrayList<Integer>();
                            al.add(1);
                            al.add(1);
                            if(1>max)
                            {
                                max=1;
                            }
                            h.put(temp.right,al);
                        }
                        else
                        {
                            ArrayList<Integer> al=new ArrayList<Integer>();
                            al.add(l.get(0)+1);
                            al.add(1);
                            if(al.get(0)>max)
                            {
                                max=al.get(0);
                            }
                            h.put(temp.right,al);
                        }
                    }
            
                    q.add(temp.right);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return max;
    }
}
