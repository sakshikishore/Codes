class Solution {
    public int minimumOperations(int[] nums) {
        if(nums.length==1)
        {
            return 0;
        }
        if(nums.length==2)
        {
            if(nums[0]!=nums[1])
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
       HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
       HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
       int countEven=0,countOdd=0;
       for(int i=0;i<nums.length;i=i+2)
       {
           countEven++;
           if(!h1.containsKey(nums[i]))
           {
               h1.put(nums[i],1);
           }
           else
           {
               h1.put(nums[i],h1.get(nums[i])+1);
           }
       }
        
       for(int i=1;i<nums.length;i=i+2)
       {
           countOdd++;
           if(!h2.containsKey(nums[i]))
           {
               h2.put(nums[i],1);
           }
           else
           {
               h2.put(nums[i],h2.get(nums[i])+1);
           }
       }
        int max1=1; // for even index
        int n1=0;
        for(Map.Entry<Integer,Integer> entry: h1.entrySet())
        {
            if(entry.getValue()>max1)
            {
                max1=entry.getValue();
                n1=entry.getKey();
            }
        }
        int max2=1; // for odd index
        int n2=0;
        for(Map.Entry<Integer,Integer> entry: h2.entrySet())
        {
            if(entry.getValue()>max2)
            {
                max2=entry.getValue();
                n2=entry.getKey();
            }
        }
        if(n1==n2)
        {
                     if(max1==countEven)
                     {
                         max2=0;
                        for(Map.Entry<Integer,Integer> entry: h2.entrySet())
                        {
                            int total=entry.getValue();
                            if(total>max2 && entry.getKey()!=n2)
                            {
                                max2=total;
                            }
                        }
                     }
                     else if(max2==countOdd)
                     {
                         max1=0;
                        for(Map.Entry<Integer,Integer> entry: h1.entrySet())
                        {
                            int total=entry.getValue();
                            if(total>max1 && entry.getKey()!=n2)
                            {
                                max1=total;
                            }
                        }
                     }
                     else
                     {
                         int m1=0,m2=0;
                        for(Map.Entry<Integer,Integer> entry: h2.entrySet())
                        {
                            int total=entry.getValue();
                            if(total>m2 && entry.getKey()!=n2)
                            {
                                m2=total;
                            }
                        }
                        int ans1=countEven-max1+countOdd-m2;
                        for(Map.Entry<Integer,Integer> entry: h1.entrySet())
                        {
                            int total=entry.getValue();
                            if(total>m1 && entry.getKey()!=n2)
                            {
                                m1=total;
                            }
                        }
                        int ans2=countEven-m1+countOdd-max2;
                        return Math.min(ans1,ans2);

                     }
                }
    
            int result=0;
            result=countOdd-max2+countEven-max1;

            return result;
    }
}
