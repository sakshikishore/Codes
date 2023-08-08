class Solution {
    public long[] getDistances(int[] arr) {
        long pref[][]=new long[arr.length][2];
        long suff[][]=new long[arr.length][2];
        HashMap<Integer,Long> h1=new HashMap<Integer,Long>();
        HashMap<Integer,Long> h2=new HashMap<Integer,Long>();
        for(int i=0;i<arr.length;i++)
        {
            if(!h1.containsKey(arr[i]))
            {
                long x=i;
                h1.put(arr[i],x);
                h2.put(arr[i],1l);
                pref[i][0]=0;
                pref[i][1]=0;
            }
            else
            {
                pref[i][0]=h1.get(arr[i]);
                pref[i][1]=h2.get(arr[i]);
                h1.put(arr[i],h1.get(arr[i])+i);
                h2.put(arr[i],h2.get(arr[i])+1);
            }
        }
       h1=new HashMap<Integer,Long>();
       h2=new HashMap<Integer,Long>();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(!h1.containsKey(arr[i]))
            {
                long x=i;
                h1.put(arr[i],x);
                h2.put(arr[i],1l);
                suff[i][0]=0;
                suff[i][1]=0;
            }
            else
            {
                suff[i][0]=h1.get(arr[i]);
                suff[i][1]=h2.get(arr[i]);
                h1.put(arr[i],h1.get(arr[i])+i);
                h2.put(arr[i],h2.get(arr[i])+1);
            }
        }
        long result[]=new long[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            result[i]=((pref[i][1]*i)-(pref[i][0]))+(suff[i][0]-(suff[i][1]*i));
           
        }

        return result;

        
    }
}
