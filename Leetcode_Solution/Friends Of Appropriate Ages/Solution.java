class Solution {
    public int numFriendRequests(int[] ages) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<ages.length;i++)
        {
            if(!h.containsKey(ages[i]))
            {
                h.put(ages[i],1);
            }
            else
            {
                h.put(ages[i],h.get(ages[i])+1);
            }
        }
        
        int arr[]=new int[h.size()];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            arr[i]=entry.getKey();
            i++;
        }

        Arrays.sort(arr);
        int count=0;
        for(i=0;i<arr.length;i++)
        {
             double p=0.5;
             p=(p*arr[i])+7;
            int val=h.get(arr[i]);
            if(val>1 && arr[i]>p)
            {
                count+=val*(val-1);
            }
            for(int j=i-1;j>=0;j--)
            {
               if(arr[j]>p)
               {
                   count+=(h.get(arr[j])*val);
               }
               else
               {
                   break;
               }
            }
        }
        
        return count;
    }
}
