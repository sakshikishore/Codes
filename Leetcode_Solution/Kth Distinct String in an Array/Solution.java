class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        int count=0;
        String result="";
        for(int i=0;i<arr.length;i++)
        {
            if(!h.containsKey(arr[i]))
            {
                h.put(arr[i],1);

            }
            else
            {
                h.put(arr[i],h.get(arr[i])+1);
            }
        }
        
        for(int i=0;i<arr.length;i++)
        {
            if(h.get(arr[i])==1)
            {
                count++;
                if(count==k)
                {
                    result=arr[i];
                    break;
                }
            }
        }
        
        return result;
    }
}
