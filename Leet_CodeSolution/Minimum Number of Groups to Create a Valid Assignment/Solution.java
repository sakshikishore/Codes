class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        int group=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int min=nums.length;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                count++;
            }
            else
            {
                h.put(nums[i-1],count);
                if(count<min)
                {
                    min=count;
                }
                count=1;
            }
        }
        if(count<min)
        {
            min=count;
        }
        h.put(nums[nums.length-1],count);
        if(min==nums.length)
        {
            return 1;
        }
        else
        {
           for(int i=1;i<=min;i++)
           {
               int res=0,flag=0;
               for(Map.Entry<Integer,Integer> entry:h.entrySet())
               {
                   int val=entry.getValue();
                   int p=val/(i+1);
                   int r=(val)%(i+1);
                   if(r==i)
                   {
                      res+=p+1; 
                   }
                   else if(r==0)
                   {
                      res+=p;
                   }
                   else
                   {
                       while(val!=0)
                       {
                           val=val-i;
                           res++;
                           if(val%(i+1)==i)
                           {
                               res+=(val/(i+1))+1;
                               break;
                           }
                           else if(val%(i+1)==0)
                           {
                                res+=val/(i+1);
                                break;
                           }
                           if(val<i && val!=0)
                           {
                             
                               flag=1;
                               break;
                           }
                       }
                       
                   }
            
               }
               if(res<group && flag==0)
               {
                   group=res;
               }
           }
        }
        
        return group;
    }
}
