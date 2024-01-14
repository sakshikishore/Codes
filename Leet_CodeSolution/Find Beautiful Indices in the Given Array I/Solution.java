class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        ArrayList<Integer> l1=new ArrayList<Integer>();
        ArrayList<Integer> l2=new ArrayList<Integer>();
        for(int i=0;i<=s.length()-a.length();i++)
        {
           String str=s.substring(i,i+a.length());
            if(str.equals(a))
            {
                l1.add(i);
            }
        }
        for(int i=0;i<=s.length()-b.length();i++)
        {
           String str=s.substring(i,i+b.length());
            if(str.equals(b))
            {
                l2.add(i);
            }
        }
        if(l1.size()==0 || l2.size()==0)
        {
            return result;
        }
        int low=0;
        for(int i=0;i<l1.size();i++)
        {
            int high=l2.size()-1,index=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l2.get(mid)>l1.get(i))
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
            if(index==l2.size())
            {
                if(l1.get(i)-l2.get(index-1)<=k)
                {
                    result.add(l1.get(i));
                }
            }
            else if(index==0)
            {
                if(l2.get(0)-l1.get(i)<=k)
                {
                    result.add(l1.get(i));
                }
            }
            else
            {
                if(l2.get(index)-l1.get(i)<=k || l1.get(i)-l2.get(index-1)<=k)
                {
                      result.add(l1.get(i));
                }
            }
            if(index==0)
            {
                low=0;
            }
            else
            {
                low=index-1;
            }
        }
        
        return result;
        
        
        
    }
}
