class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashSet<Integer> h=new HashSet<Integer>();
        HashMap<Integer,ArrayList<Integer>> h1=new HashMap<Integer,ArrayList<Integer>>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(temp.val);
            if(temp.left!=null)
            {
                q.add(temp.left);
                l.add(temp.left.val);
                ArrayList<Integer> al=new ArrayList<Integer>();
                al.add(temp.val);
                h1.put(temp.left.val,al);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
                l.add(temp.right.val);
                ArrayList<Integer> al=new ArrayList<Integer>();
                al.add(temp.val);
                h1.put(temp.right.val,al);
            }
            if(!h1.containsKey(temp.val))
            {
               h1.put(temp.val,l);
            }
            else
            {
                ArrayList<Integer> alist=h1.get(temp.val);
                for(int i=0;i<l.size();i++)
                {
                    alist.add(l.get(i));
                }
                h1.put(temp.val,alist);
            }
            
        }
        Queue<Integer> qu=new LinkedList<Integer>();
           int count=0;
           HashSet<Integer> hset=new HashSet<Integer>();
           hset.add(start);
           int flag=0;
          ArrayList<Integer> record=new ArrayList<Integer>();
           record.add(start);
           while(flag!=1)
           {
               flag=1;
              ArrayList<Integer> temp=new ArrayList<Integer>();
              for(int j=0;j<record.size();j++)
              {
                  ArrayList<Integer> l=h1.get(record.get(j));
                  for(int k=0;k<l.size();k++)
                  {
                      if(l.get(k)!=record.get(j) && !hset.contains(l.get(k)))
                      {
                          flag=0;
                          temp.add(l.get(k));
                          hset.add(l.get(k));
                      }
                  }
              }
               
               if(flag==0)
               {
                   count++;
               }
               record=new ArrayList<Integer>();
               for(int i=0;i<temp.size();i++)
               {
                   record.add(temp.get(i));
               }
               
           }
           
        
        return count;
    
        
        
        
    }
}
