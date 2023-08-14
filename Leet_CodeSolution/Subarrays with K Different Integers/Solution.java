class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int result=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                l.add(i);
                ArrayList<Integer> al=new ArrayList<Integer>();
                al.add(i);
                h.put(nums[i],al);
            }
            else
            {
                ArrayList<Integer> al=h.get(nums[i]);
                al.add(i);
                h.put(nums[i],al);
            }
        }
        while(l.size()>=k)
        {
           int p=l.get(k-1);
           if(k==l.size())
           {
               if(l.get(k-1)!=nums.length-1)
              {
                     result+=nums.length-l.get(k-1);
              }
              else
              {
               result++;
              }
           }
           else
           {
               result+=l.get(k)-p;
           }
           int x=nums[l.get(0)];
           l.remove(0);
           ArrayList<Integer> al=h.get(x);
           al.remove(0);
           if(al.size()==0)
           {
               h.remove(x);
           }
           else
           {
               int val=al.get(0);
               h.put(x,al);
               int low=0,high=l.size()-1,index=0;
               while(low<=high)
               {
                   int mid=(low+high)/2;
                   if(l.get(mid)>val)
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
               l.add(index,val);
           }
        }

        return result;
    }
}
