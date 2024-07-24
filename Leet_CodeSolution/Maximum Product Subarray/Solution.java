import java.math.BigInteger;
class Solution {
    public int maxProduct(int[] nums) {
        ArrayList<Integer> l=new ArrayList<Integer>(); // it will add negative value index
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                l.add(i);
            }
        }
        int start=0;
        BigInteger prod=BigInteger.valueOf(nums[0]);
        BigInteger result=prod;
        BigInteger pref[]=new BigInteger[nums.length];
        pref[0]=prod;
        if(prod.compareTo(BigInteger.valueOf(0))==0)
        {
            prod=BigInteger.valueOf(1);
            start=start+1;
        }
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                start=i+1;
                pref[i]=BigInteger.valueOf(0);
                prod=BigInteger.valueOf(1);
                if(result.compareTo(BigInteger.valueOf(0))==-1)
                {
                    result=BigInteger.valueOf(0);
                }
            }
            else
            {
                prod=prod.multiply(BigInteger.valueOf(nums[i]));
                pref[i]=prod;
                if(prod.compareTo(BigInteger.valueOf(0))==-1)
                {
                    int low=0,high=l.size()-1,index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)==start)
                        {
                            index=mid;
                            break;
                        }
                        if(l.get(mid)>start)
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
                    if(l.get(index)!=i)
                    {
                        BigInteger x=prod.divide(pref[l.get(index)]);
                        if(x.compareTo(result)==1)
                        {
                            result=x;
                        }
                    }

                }
                else if(prod.compareTo(result)==1)
                {
                    result=prod;
                }
            }
        }

        return result.intValue();
    }
}
