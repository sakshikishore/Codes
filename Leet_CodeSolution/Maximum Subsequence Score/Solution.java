class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>> ();
        for(int i=0;i<nums1.length;i++)
        {
            if(!h.containsKey(nums2[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(nums1[i]);
                h.put(nums2[i],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(nums2[i]);
                l.add(nums1[i]);
                h.put(nums2[i],l);
            }
        }
        Arrays.sort(nums2);
        for(int i=0;i<nums2.length;i++)
        {
            ArrayList<Integer> l=h.get(nums2[i]);
            nums1[i]=l.get(0);
            l.remove(0);
            if(l.size()>0)
            {
                h.put(nums2[i],l);
            }
            else
            {
                h.remove(nums2[i]);
            }
        }
        long sum=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=nums1.length-1;i>=nums1.length-k;i--)
        {
            sum=sum+nums1[i];
            if(list.size()==0)
            {
                list.add(nums1[i]);
            }
            else
            {
                int index=0;
                int low=0,high=list.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(list.get(mid)>=nums1[i])
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
                list.add(index,nums1[i]);
            }
        }
        long result=(nums2[nums1.length-k]*sum);
        for(int i=nums1.length-k-1;i>=0;i--)
        {
                int index=0;
                int low=0,high=list.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(list.get(mid)>=nums1[i])
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
                if(index!=0)
                {
                  list.add(index,nums1[i]);
                  sum=sum-list.get(0);
                  sum=sum+nums1[i];
                  list.remove(0);
                long ans=sum*nums2[i];
                if(ans>result)
                {
                    result=ans;
                }
    }           
        }

        return result;
    }
}
