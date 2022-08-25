class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean result=true;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
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
        int root=-1;
        if(result)
        {
            int count=0;
            for(int i=0;i<n;i++)
            {
                if(!h.containsKey(i))
                {
                    root=i;
                    count++;
                }
            }
            if(count>1)
            {
                result=false;
            }
        }
        if(result)
        {
            HashSet<Integer> hset=new HashSet<Integer>();
            hset.add(root);
            Queue<Integer> q=new LinkedList<Integer>();
            q.add(root);
            while(q.size()>0)
            {
                int node=q.poll();
                if(leftChild[node]!=-1)
                {
                    if(hset.contains(leftChild[node]))
                    {
                        result=false;
                        break;
                    }
                    else
                    {
                        hset.add(leftChild[node]);
                        q.add(leftChild[node]);
                    }

                }
                if(rightChild[node]!=-1)
                {
                    if(hset.contains(rightChild[node]))
                    {
                        result=false;
                        break;
                    }
                    else
                    {
                        hset.add(rightChild[node]);
                        q.add(rightChild[node]);
                    }

                }
            }
            if(result)
            {
                if(hset.size()!=n)
                {
                    result=false;
                }
            }
        }
        
        return result;
    }
}
