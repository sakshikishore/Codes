class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int p=nums.length-k;
        double result[]=new double[p+1];
        ArrayList<Integer> l=new ArrayList<Integer>();
        int j=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i<k)
            {
                l.add(nums[i]);
                if(i==k-1)
                {
                     Collections.sort(l);
                }
            }
            else
            {
                int x=nums[j];
                if(k%2==0)
                {
                    int a=k/2;
                    int b=a-1;
                    double y=l.get(a)*1.0;
                    result[j]=(y+l.get(b))/2.0;
                }
                else
                {
                    int a=k/2;
                    result[j]=l.get(a)*(1.0);
                }
                j++;
                int low=0,high=k-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    int z=l.get(mid);
                    if(z==x)
                    {
                        l.remove(mid);
                        break;
                    }
                    else
                    {
                        if(z<x)
                        {
                            low=mid+1;
                        }
                        else
                        {
                            high=mid-1;
                        }
                    }
                }
                low=0;
                high=k-2;
                int index=-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    int z=l.get(mid);
                    if(z>nums[i])
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
                if(index==-1)
                {
                    index=0;
                }
             
                l.add(index,nums[i]);
                

            }
        }
                if(k%2==0)
                {
                    int a=k/2;
                    double y=l.get(a)*1.0;
                    int b=a-1;
                    result[j]=(y+l.get(b))/2.0;
                }
                else
                {
                    int a=k/2;
                    result[j]=l.get(a)*(1.0);
                }
        return result;

    }
}
