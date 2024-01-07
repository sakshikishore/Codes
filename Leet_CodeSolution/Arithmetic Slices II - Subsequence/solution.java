class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        ArrayList<HashMap<Long,Integer>> list=new ArrayList<HashMap<Long,Integer>>();
        int result=0;
        for(int i=1;i<nums.length;i++)
        {
           HashMap<Long,Integer> h=new HashMap<Long,Integer>();
           if(i==1)
           {
               h.put(nums[i]*1L-nums[0],1);
               list.add(h);
           }
           else
           {
               for(int j=i-1;j>=0;j--)
               {
                   long diff=nums[i]*1L-nums[j];
                   if(j==0)
                   {
                       if(!h.containsKey(diff))
                       {
                           h.put(diff,1);
                       }
                       else
                       {
                           h.put(diff,h.get(diff)+1);
                       }
                       break;
                   }
                   HashMap<Long,Integer> hj=list.get(j);
                   if(hj.containsKey(diff))
                   {
                       result+=hj.get(diff);
                       if(!h.containsKey(diff))
                       {
                           h.put(diff,hj.get(diff)+1);
                       }
                       else
                       {
                           h.put(diff,h.get(diff)+hj.get(diff)+1);
                       }
                   }
                   else
                   {
                       if(!h.containsKey(diff))
                       {
                           h.put(diff,1);
                       }
                       else
                       {
                           h.put(diff,h.get(diff)+1);
                       }
                   }
               }
           }
           list.add(h);
        }

        return result;
    }
}
