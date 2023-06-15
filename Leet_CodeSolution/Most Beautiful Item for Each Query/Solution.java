class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int result[]=new int[queries.length];
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<items.length;i++)
        {
             if(!h.containsKey(items[i][0]))
             {
                 h.put(items[i][0],items[i][1]);
                 l.add(items[i][0]);
             }
             else
             {
                 if(h.get(items[i][0])<items[i][1])
                 {
                     h.put(items[i][0],items[i][1]);
                 }
             }
        }
        int max=0;
        Collections.sort(l);
        int arr[]=new int[l.size()];
        for(int i=0;i<l.size();i++)
        {
            if(h.get(l.get(i))>max)
            {
                max=h.get(l.get(i));
            }
            arr[i]=max;
        }
        for(int i=0;i<queries.length;i++)
        {
            int low=0,high=l.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)==queries[i])
                {
                    result[i]=arr[mid];
                    break;
                }
                else if(l.get(mid)<queries[i])
                {
                    result[i]=arr[mid];
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }

            }
        }

        return result;
    }
}
