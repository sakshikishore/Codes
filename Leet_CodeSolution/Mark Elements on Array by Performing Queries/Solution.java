class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        long sum=0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            list.add(nums[i]);
            sum+=nums[i];
            if(!h.containsKey(nums[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(nums[i],l);
            }
            else
            {
               ArrayList<Integer> l=h.get(nums[i]);
                l.add(i);
                h.put(nums[i],l);
            }
        }
        Collections.sort(list);
        
     long result[]=new long[queries.length];
        HashSet<Integer> hset=new HashSet<Integer>();
    
     for(int i=0;i<queries.length;i++)
     {
         int index=queries[i][0];
         int k=queries[i][1];
             if(!hset.contains(index))
             {
                 hset.add(index);
                 ArrayList<Integer> l=h.get(nums[index]);
                 int low=0,high=l.size()-1;
                 while(low<=high)
                 {
                     int mid=(low+high)/2;
                     if(l.get(mid)==index)
                     {
                         l.remove(mid);
                         sum=sum-nums[index];
                         break;
                     }
                     else if(l.get(mid)>index)
                     {
                         high=mid-1;
                     }
                     else
                     {
                         low=mid+1;
                     }
                 }
                 
                 low=0;
                 high=list.size()-1;
                 while(low<=high)
                 {
                     int mid=(low+high)/2;
                     if(list.get(mid)==nums[index])
                     {
                         list.remove(mid);
                         break;
                     }
                     else if(list.get(mid)>nums[index])
                     {
                         high=mid-1;
                     }
                     else
                     {
                         low=mid+1;
                     }
                 }
             }
             int j=0;
             while(j<k && list.size()>0)
             {
                 int x=list.get(0);
                 ArrayList<Integer> al=h.get(x);
                 while(al.size()>0 && j<k)
                 {
                       list.remove(0);
                       sum=sum-x;
                       hset.add(al.remove(0));
                     j++;
                 }
                 if(al.size()==0)
                 {
                     h.remove(x);
                 }
                 else
                 {
                     h.put(x,al);
                 }
                 

             }
        
         result[i]=sum;
     }
        
        return result;
    }
}
