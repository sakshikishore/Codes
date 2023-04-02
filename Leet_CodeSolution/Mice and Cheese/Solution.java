class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n=reward1.length;
        int res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
            int x=reward1[i]-reward2[i];
            if(!h.containsKey(x))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(x,l);
                pq.add(x);
            }
            else
            {
                ArrayList<Integer> l=h.get(x);
                l.add(i);
                h.put(x,l);
            }
        }
        int j=0;
        while(pq.size()>0)
        {
           if(j==k)
            {
                  break;
            }
            int r=pq.poll();
            ArrayList<Integer> l=h.get(r);
            for(int i=0;i<l.size();i++)
            {
                int p=l.get(i);
                reward2[p]=reward1[p];
                j++;
                if(j==k)
                {
                    break;
                }
            }
            if(j==k)
            {
                break;
            }
        }
           for(int i=0;i<n;i++)
           {
               res+=reward2[i];
           }
        
        return res;
    }
}
