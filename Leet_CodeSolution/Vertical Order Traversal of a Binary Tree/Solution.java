class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<TreeNode,Integer> map=new HashMap<TreeNode,Integer>();
        HashMap<Integer,Integer> tracker=new HashMap<Integer,Integer>();
        List<List<Integer>> result=new ArrayList();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(root.val);
        h.put(0,l);
        map.put(root,0);
        pq.add(0);
        tracker.put(0,1);
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp==null)
            {
                 if(q.size()>0)
                 {
                     q.add(null);
                     for(Map.Entry<Integer,ArrayList<Integer>> entry:h.entrySet())
                     {
                         tracker.put(entry.getKey(),entry.getValue().size());
                     }
                 }
            }
            else
            {
                int x=map.get(temp);
            if(temp.left!=null)
            {
                q.add(temp.left);
                map.put(temp.left,x-1);
                if(!h.containsKey(x-1))
                {
                    pq.add(x-1);
                    l=new ArrayList<Integer>();
                    l.add(temp.left.val);
                    h.put(x-1,l);
                }
                else
                {
                    l=h.get(x-1);
                    int low=0;
                    if(tracker.containsKey(x-1))
                    { 
                        low=tracker.get(x-1);
                    }
                    int high=l.size()-1;
                    if(high<low)
                    {
                         l.add(temp.left.val);
                    }
                    else
                    {
                           int index=low;
                           while(low<=high)
                           {
                               int mid=(low+high)/2;
                               if(l.get(mid)>temp.left.val)
                               {
                                   index=mid;
                                   high=mid-1;
                               }
                               else
                               {
                                   low=mid+1;
                                   index=mid+1;
                               }
                           }
                           l.add(index,temp.left.val);
                    }
                    
                    h.put(x-1,l);
                }
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
                map.put(temp.right,x+1);
                if(!h.containsKey(x+1))
                {
                    pq.add(x+1);
                    l=new ArrayList<Integer>();
                    l.add(temp.right.val);
                    h.put(x+1,l);
                }
                else
                {
                    l=h.get(x+1);
                    int low=0;
                    if(tracker.containsKey(x+1))
                    { 
                        low=tracker.get(x+1);
                    }
                    int high=l.size()-1;
                    if(high<low)
                    {
                         l.add(temp.right.val);
                    }
                    else
                    {
                          int index=low;
                           while(low<=high)
                           {
                               int mid=(low+high)/2;
                               if(l.get(mid)>temp.right.val)
                               {
                                   index=mid;
                                   high=mid-1;
                               }
                               else
                               {
                                   low=mid+1;
                                   index=mid+1;
                               }
                           }
                           l.add(index,temp.right.val);
                    }

                    h.put(x+1,l);
                }
            }
            }
        }

        while(pq.size()>0)
        {
            result.add(h.get(pq.poll()));
        }

        return result;

    }
}
