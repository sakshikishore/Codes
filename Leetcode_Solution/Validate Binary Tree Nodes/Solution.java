class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<leftChild.length;i++)
        {
            if(leftChild[i]!=-1)
            {
            if(h.containsKey(leftChild[i]))
            {
                return false;
            }
            else
            {
                if(h.containsKey(i) && h.get(i)==leftChild[i])
                {
                    return false;
                }
               
                h.put(leftChild[i],i);
            }
            }
        }
         for(int i=0;i<rightChild.length;i++)
        {
                if(rightChild[i]!=-1)
                {
                if(h.containsKey(rightChild[i]))
                {
                    return false;
                }
                else
                {
                    if(h.containsKey(i) && h.get(i)==rightChild[i])
                    {
                        return false;
                    }
                    h.put(rightChild[i],i);
                }
            }
        }
      int root=0;
      Queue<Integer> q=new LinkedList<Integer>();
      q.add(root);
      HashSet<Integer> hset=new HashSet<Integer>();
      hset.add(root);
      while(q.size()>0)
      {
          root=q.poll();
          if(h.containsKey(root))
          {
              root=h.get(root);
              if(hset.contains(root))
              {
                  return false;
              }
              q.add(root);
              hset.add(root);
          }
      }
       for(int i=1;i<n;i++)
       {
           if(h.containsKey(i))
           {
               if(h.get(i)!=root && !h.containsKey(h.get(i)))
               {
                   return false;
               }
           }
       }
        return true;
    }
}
