class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int result[]=new int[queries.length];
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='|')
            {
                l.add(i);
            }
        }
        if(l.size()==0)
        {
            return result;
        }
        int pref[]=new int[l.size()];
        int sum=0;
        pref[0]=0;
        for(int i=1;i<l.size();i++)
        {
           sum+=l.get(i)-l.get(i-1)-1;
           pref[i]=sum;
        }
        for(int i=0;i<queries.length;i++)
        {
            int left=queries[i][0];
            int right=queries[i][1];
            int low=0,high=l.size()-1,leftIndex=0,rightIndex=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>left)
                {
                    leftIndex=mid;
                    high=mid-1;
                }
                else if(l.get(mid)==left)
                {
                    leftIndex=mid;
                    break;
                }
                else
                {
                    leftIndex=mid+1;
                    low=mid+1;
                }
            }
            low=0;
            high=l.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>right)
                {
                    rightIndex=mid-1;
                    high=mid-1;
                }
                else if(l.get(mid)==right)
                {
                    rightIndex=mid;
                    break;
                }
                else
                {
                    rightIndex=mid;
                    low=mid+1;
                }
            }
            if(leftIndex<=rightIndex)
            {
                result[i]=pref[rightIndex]-pref[leftIndex];
            }
        }

        return result;
    }
}
