class Solution {
    public int countDays(int days, int[][] meetings) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<meetings.length;i++)
        {
            if(!h.containsKey(meetings[i][0]))
            {
                h.put(meetings[i][0],meetings[i][1]);
                l.add(meetings[i][0]);
            }
            else
            {
                if(h.get(meetings[i][0])<meetings[i][1])
                {
                    h.put(meetings[i][0],meetings[i][1]);
                }
            }
        }
        int count=0;
        Collections.sort(l);
        int start=l.get(0);
        if(start!=1)
        {
            count+=start-1;
        }
        int end=h.get(start);
        for(int i=1;i<l.size();i++)
        {
            int s=l.get(i);
            int e=h.get(l.get(i));
            if(s<=end)
            {
                if(e>=end)
                {
                    end=e;
                }
            }
            else
            {
                count+=(s-end-1);
                start=s;
                end=e;
            }

        }
      
        
        count+=days-end;
        

        return count;
    }
}
