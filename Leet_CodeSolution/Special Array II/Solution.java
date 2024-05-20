class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<nums.length;i++)
        {
            if((nums[i]%2==0 && nums[i-1]%2==0) || (nums[i]%2!=0 && nums[i-1]%2!=0))
            {
                list.add(i-1);
            }
        }
        boolean result[]=new boolean[queries.length];
        
        for(int i=0;i<queries.length;i++)
        {
            int x=queries[i][0];
            int y=queries[i][1];
            int low=0,high=list.size()-1,index1=0;
            while(low<=high)
            {
               int mid=(low+high)/2;
               if(list.get(mid)>=x)
               {
                   index1=mid;
                   high=mid-1;
               }
                else
                {
                    index1=mid+1;
                    low=mid+1;
                }
            }
            
            low=0;
            high=list.size()-1;
            int index2=0;
            while(low<=high)
            {
               int mid=(low+high)/2;
               if(list.get(mid)>=y)
               {
                   index2=mid;
                   high=mid-1;
               }
                else
                {
                    index2=mid+1;
                    low=mid+1;
                }
            }
             if(index1==index2)
           {
            result[i]=true;
           }
            else
            {
               result[i]=false;
            }
        }
        
        return result;
    }
}
