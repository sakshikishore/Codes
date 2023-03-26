class Solution {
    public boolean primeSubOperation(int[] nums) {
       ArrayList<Integer> l=new ArrayList<Integer>();
       for(int i=2;i<1000;i++)
       {
           int flag=0;
          for(int j=2;j<=i/2;j++)
          {
              if(i%j==0)
              {
                  flag=1;
                  break;
              }
          }
          if(flag==0)
          {
              l.add(i);
          }
       }
       for(int i=nums.length-2;i>=0;i--)
       {
           if(nums[i]>=nums[i+1])
           {
               int p=-1;
                 for(int j=0;j<l.size();j++)
                 {
                     
                     if(l.get(j)<nums[i])
                     {
                         if(nums[i]-l.get(j)<nums[i+1])
                         {
                            p=nums[i]-l.get(j);
                            break;
                         }
                     }
                     else
                     {
                         if(p==-1)
                         {
                             return false;
                         }
                         else
                         {
                             nums[i]=p;
                         }
                     }
                 }
                 if(p==-1)
                         {
                             return false;
                         }
                         else
                         {
                             nums[i]=p;
                         }
           }
       }
       return true;
    }
}
