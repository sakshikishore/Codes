class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        long m=mass;
        for(int i=0;i<asteroids.length;i++)
        {
            l.add(asteroids[i]);
        }
        Collections.sort(l);
        while(l.size()>0)
        {
                int low=0,high=l.size()-1,index=0;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>m)
                    {
                        high=mid-1;
                        index=mid;
                    }
                    else
                    {
                        low=mid+1;
                        index=mid+1;
                    }
                }
                if(index==0)
                {
                    return false;
                }
                else
                {
                    m+=l.remove(index-1);
                }
        }

        return true;
    }
}
