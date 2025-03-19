class Solution {
    public int waysToSplit(int[] nums) {
       ArrayList<Long> l=new ArrayList<Long>();
       long p=nums[0]*1l;
       l.add(p);
       for(int i=1;i<nums.length;i++)
       {
         p=p+nums[i];
         l.add(p);
       } 
       long sum=0l,result=0l;
       for(int i=0;i<nums.length-2;i++)
       {
         sum=sum+nums[i];
         l.remove(0);
         long min=sum,max=(l.get(l.size()-1)-sum)/2;
         if(min>max)
         {
            break;
         }
         int low=0,high=l.size()-1;
         int minIndex=0,maxIndex=0;
         while(low<=high)
         {
            int mid=(low+high)/2;
            if(l.get(mid)-sum>=min)
            {
                high=mid-1;
                minIndex=mid;
            }
            else if(l.get(mid)-sum<min)
            {
                minIndex=mid+1;
                low=mid+1;
            }
         }

         if(minIndex==l.size())
         {
            return (int)result;
         }
         if(l.get(minIndex)-sum>max){
            continue;
         }
         low=0;
         high=l.size()-1;
         while(low<=high)
         {
            int mid=(low+high)/2;
            if(l.get(mid)-sum>max)
            {
                high=mid-1;
                maxIndex=mid;
            }
            else if(l.get(mid)-sum<=max)
            {
                maxIndex=mid+1;
                low=mid+1;
            }
         }
         if(maxIndex==l.size())
         {
            maxIndex=maxIndex-1;
         }
         long x=(maxIndex-minIndex)*1l;
         result+=x; 
         result=result%(1000000007);
       }

       return (int)result;
    }
}
