class SummaryRanges {
    ArrayList<Integer> l;
    HashSet<Integer> h;
    public SummaryRanges() {
        l=new ArrayList<Integer>();
        h=new HashSet<Integer>();
    }
    
    public void addNum(int value) {
        if(!h.contains(value))
        {
            h.add(value);
            if(l.size()==0)
            {
                l.add(value);
            }
            else if(l.size()==1)
            {
                if(l.get(0)>value)
                {
                    l.add(0,value);
                }
                else
                {
                    l.add(value);
                }
            }
            else
            {
                int low=0,high=l.size()-1,index=-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>value)
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
                l.add(index,value);
            }
        }
    }
    
    public int[][] getIntervals() {
        if(l.size()==0)
        {
            int arr[][]=new int[0][0];
            return arr;
        }
        int start=l.get(0);
        List<List<Integer>> list=new ArrayList();
        for(int i=1;i<l.size();i++)
        {
            if(l.get(i)-l.get(i-1)!=1)
            {
                ArrayList<Integer> al=new ArrayList<Integer>();
                al.add(start);
                al.add(l.get(i-1));
                list.add(al);
                start=l.get(i);
            }
        }
        ArrayList<Integer> al=new ArrayList<Integer>();
        al.add(start);
        al.add(l.get(l.size()-1));
        list.add(al);
        int result[][]=new int[list.size()][2];
        for(int i=0;i<list.size();i++)
        {
            result[i][0]=list.get(i).get(0);
            result[i][1]=list.get(i).get(1);
        }

        return result;
    }
}
