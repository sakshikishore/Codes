class Solution {
    public int countPairs(int[] deliciousness) {
        long count=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int arr[]=new int[22];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=(int)Math.pow(2,i);
        }
        for(int i=0;i<deliciousness.length;i++)
        {
            if(!h.containsKey(deliciousness[i]))
            {
                h.put(deliciousness[i],1);
            }
            else
            {
                h.put(deliciousness[i],h.get(deliciousness[i])+1);
            }
        }
        HashSet<Integer> hset=new HashSet<Integer>();
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            int key=entry.getKey();
            for(int i=0;i<arr.length;i++)
            {
                int x=arr[i]-key;
                if(x==key)
                {
                    long val=0;
                    val=val+entry.getValue();
                    count+=((val)*(val-1))/2;
                    count=count%(1000000007);
                }
                else
                {
                    if(!hset.contains(x))
                    {
                        if(h.containsKey(x))
                        {
                            long val1=0;
                            val1=val1+entry.getValue();
                            long val2=0;
                            val2=val2+h.get(x);
                            count+=val1*val2;
                            count=count%(1000000007);
                        }
                    }
                }
            }
            hset.add(key);
        }
        
        return (int)count;
    }
}
