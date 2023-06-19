class Solution {
    public long maximumOr(int[] nums, int k) {
       int arr[]=new int[nums.length];
       int max=0;
       ArrayList<Integer> l=new ArrayList<Integer>();
       for(int i=0;i<nums.length;i++)
       {
           arr[i]=((int)(Math.log(nums[i])/Math.log(2)))+1;
           if(arr[i]>max)
           {
               l=new ArrayList<Integer>();
               max=arr[i];
               l.add(nums[i]);
           }
           else if(arr[i]==max)
           {
               l.add(nums[i]);
           }
       }
       long ans=0;
       for(int i=0;i<nums.length;i++)
       {
           if(arr[i]!=max)
           {
               ans=(ans | nums[i]);
           }
       }
       long p[]=new long[l.size()];
       long s[]=new long[l.size()];
       long val=0;
       for(int i=0;i<l.size();i++)
       {
           val=(l.get(i) | val);
           p[i]=val;
       }
       val=0;
       for(int i=l.size()-1;i>=0;i--)
       {
           val=(l.get(i) | val);
           s[i]=val;
       }
       long result=0;
       long r=(long)Math.pow(2,k);
       for(int i=0;i<l.size();i++)
       {
           long a=0;
           if(i==0)
           {
               if(i+1<l.size())
               {
                a=(ans | s[i+1]);
                a=(a | l.get(i)*r);
                if(a>result)
                {
                    result=a;
                }
               }
               else
               {
                    a=(ans | l.get(i)*r);
                    if(a>result)
                    {
                        result=a;
                    }
               }
           }
           else if(i==l.size()-1)
           {
               a=(ans | p[i-1]);
               a=(a | l.get(i)*r);
               if(a>result)
               {
                   result=a;
               }
           }
           else
           {
               a=(ans | p[i-1]);
               a=(a | s[i+1]);
               a=(a | l.get(i)*r);
               if(a>result)
               {
                   result=a;
               }
           }
       }
       

       return result;

    }
}
