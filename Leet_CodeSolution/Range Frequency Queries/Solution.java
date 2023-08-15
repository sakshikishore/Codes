class RangeFreqQuery {
    HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
    public RangeFreqQuery(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
            if(!h.containsKey(arr[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(arr[i],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(arr[i]);
                l.add(i);
                h.put(arr[i],l);
            }
        }
    }
    
    public int query(int left, int right, int value) {
        if(!h.containsKey(value))
        {
            return 0;
        }
        else
        {
            ArrayList<Integer> l=h.get(value);
            if(l.get(0)>right || l.get(l.size()-1)<left)
            {
                return 0;
            }
            else
            {
                int low=0,high=l.size()-1,index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>=left)
                    {
                        index=mid;
                        high=mid-1;
                    }
                    else
                    {
                        index=mid+1;
                        low=mid+1;
                    }
                }
                int lower=index;
                low=0;
                high=l.size()-1;
                index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)<=right)
                    {
                        index=mid;
                        low=mid+1;
                    }
                    else
                    {
                        index=mid-1;
                        high=mid-1;
                    }
                }
                int higher=index;
               return higher-lower+1;
            }
        }

    }
}
