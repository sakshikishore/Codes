class SnapshotArray {
    int snap_id=0;
    HashMap<Integer,ArrayList<Integer>> h1; // index,snap_id
    HashMap<Integer,ArrayList<Integer>> h2;//index, val
    public SnapshotArray(int length) {
        h1=new  HashMap<Integer,ArrayList<Integer>>();
        h2=new  HashMap<Integer,ArrayList<Integer>>();
    }
    
    public void set(int index, int val) {
        if(!h1.containsKey(index))
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(snap_id);
            h1.put(index,l);
            ArrayList<Integer> al=new ArrayList<Integer>();
            al.add(val);
            h2.put(index,al);

        }
        else
        {
            ArrayList<Integer> l=h1.get(index);
            int len=l.size()-1;
            if(l.get(len)==snap_id)
            {
                ArrayList<Integer> al=h2.get(index);
                al.remove(len);
                al.add(val);
                h2.put(index,al);
            }
            else
            {
                l.add(snap_id);
                h1.put(index,l);
                ArrayList<Integer> al=h2.get(index);
                al.add(val);
                h2.put(index,al);
            
            }
        }
    }
    
    public int snap() {
        snap_id++;
        return snap_id-1;
    }
    
    public int get(int index, int snap_id) {
        if(!h1.containsKey(index))
        {
            return 0;
        }
        else
        {
            ArrayList<Integer> l=h1.get(index);
            ArrayList<Integer> al=h2.get(index);
            int low=0,high=l.size()-1;
            int result=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)==snap_id)
                {
                    return al.get(mid);
                }
                else if(l.get(mid)>snap_id)
                {
                    high=mid-1;
                }
                else
                {
                    result=al.get(mid);
                    low=mid+1;
                }
            }

            return result;

        }
    }
}
