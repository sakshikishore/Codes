class Solution {
    public int maximumSum(int[] arr) {
        int max=Integer.MIN_VALUE;
        if(arr.length==1)
        {
            return arr[0];
        }
        int pref[]=new int[arr.length];
        pref[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(pref[i-1]+arr[i]>arr[i])
            {
                pref[i]=pref[i-1]+arr[i];
            }
            else
            {
                pref[i]=arr[i];
            }
        }
        int suf[]=new int[arr.length];
        suf[suf.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--)
        {
            if(suf[i+1]+arr[i]>arr[i])
            {
                suf[i]=suf[i+1]+arr[i];
            }
            else
            {
                suf[i]=arr[i];
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            if(i==0)
            {
                if(suf[i+1]>max)
                {
                    max=suf[i+1];
                }
            }
            else if(i==arr.length-1)
            {
                if(pref[i-1]>max)
                {
                    max=pref[i-1];
                }
            }
            else
            {
                if(pref[i-1]+suf[i+1]>max)
                {
                    max=pref[i-1]+suf[i+1];
                }
                if(pref[i-1]>max)
                {
                    max=pref[i-1];
                }
                if(suf[i+1]>max)
                {
                    max=suf[i+1];
                }
                if(arr[i]+pref[i-1]+suf[i+1]>max)
                {
                    max=arr[i]+pref[i-1]+suf[i+1];
                }
            }
        }

        return max;
    }
}
