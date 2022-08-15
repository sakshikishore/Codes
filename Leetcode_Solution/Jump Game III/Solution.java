class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean result=false;
        if(arr[start]==0)
        {
            return true;
        }
        else
        {
            HashSet<Integer> h=new HashSet<Integer>();
            Queue<Integer> q=new LinkedList<Integer>();
            h.add(start);
            q.add(start);
            while(q.size()>0)
            {
                int i=q.poll();
                int a=i+arr[i];
                int b=i-arr[i];
                if(a<arr.length)
                {
                    if(arr[a]==0)
                    {
                        result=true;
                        break;
                    }
                    if(!h.contains(a))
                    {
                        h.add(a);
                        q.add(a);
                    }
                }
                if(b>=0)
                {
                    if(arr[b]==0)
                    {
                        result=true;
                        break;
                    }
                    if(!h.contains(b))
                    {
                        h.add(b);
                        q.add(b);
                    }
                }
            }
        }
        
        return result;
    }
}
