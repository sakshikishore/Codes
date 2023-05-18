class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<0)
            {
                int p=arr[i]%k;
                if(p!=0)
                {
                  arr[i]=k+p;
                }
                else
                {
                    arr[i]=0;
                }
                if(!h.containsKey(arr[i]))
                {
                    h.put(arr[i],1);
                }
                else
                {
                    h.put(arr[i],h.get(arr[i])+1);
                }
            }
            else
            {
                arr[i]=arr[i]%k;
                if(!h.containsKey(arr[i]))
                {
                    h.put(arr[i],1);
                }
                else
                {
                    h.put(arr[i],h.get(arr[i])+1);
                }

            }
        }
        for(int i=0;i<k;i++)
        {
            if(i==0)
            {
                if(h.containsKey(0))
                {
                    int x=h.get(0);
                    if(x%2!=0)
                    {
                        return false;
                    }
                }
            }
            else
            {
                if(h.containsKey(i))
                {
                    int p=k-i;
                    if(!h.containsKey(p))
                    {
                        return false;
                    }
                    else
                    {
                        int x=h.get(i);
                        int y=h.get(p);
                        if(x!=y)
                        {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
