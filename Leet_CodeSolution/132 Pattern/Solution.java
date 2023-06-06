class Solution {
    public boolean find132pattern(int[] nums) {
        int pref[]=new int[nums.length];
        int suff[]=new int[nums.length];
        pref[0]=nums[0];
        int pMin=nums[0];
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=1;i<nums.length;i++)
        {
            l.add(nums[i]);
           if(nums[i]<pMin)
           {
               pref[i]=nums[i];
               pMin=nums[i];
           }
           else
           {
               pref[i]=pMin;
           }
        }
        Collections.sort(l);
        for(int i=1;i<nums.length-1;i++)
        {
             int p=0;
             int low=0,high=l.size()-1;
             while(low<=high)
             {
                 int mid=(low+high)/2;
                 if(l.get(mid)>=nums[i])
                 {
                     p=mid;
                     high=mid-1;
                 }
                 else
                 {
                     low=mid+1;
                 }
             }
            if(pref[i]!=nums[i])
            {
                if(p!=0 && l.get(p-1)>pref[i])
                {
                  return true;
                }
            }
            l.remove(p);
        }

        return false;
    }
}
