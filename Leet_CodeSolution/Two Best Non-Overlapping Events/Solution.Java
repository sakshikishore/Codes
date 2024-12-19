class Solution {
    public int maxTwoEvents(int[][] events) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int max=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<events.length;i++)
        {
            if(!h.containsKey(events[i][0]))
            {
                h.put(events[i][0],events[i][2]);
                l.add(events[i][0]);
            }
            else
            {
                if(h.get(events[i][0])<events[i][2])
                {
                    h.put(events[i][0],events[i][2]);
                }
            }
        }

        Collections.sort(l);
        int arr[]=new int[l.size()];
        arr[l.size()-1]=h.get(l.get(l.size()-1));
        for(int i=arr.length-2;i>=0;i--)
        {
            int val=h.get(l.get(i));
            if(val>arr[i+1])
            {
                arr[i]=val;
            }
            else
            {
                arr[i]=arr[i+1];
            }
        }

        for(int i=0;i<events.length;i++)
        {
            int x=events[i][1];
            int low=0,high=l.size()-1;
            int index=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>x)
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
            if(index!=l.size())
            {
               if(arr[index]+events[i][2]>max)
               {
                max=arr[index]+events[i][2];
               }
            }
            else
            {
                if(events[i][2]>max)
                {
                    max=events[i][2];
                }
            }

        }


        return max;
        
    }
}
