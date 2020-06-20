class Solution {
    public int findSpecialInteger(int[] arr) {
     HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int result=0;
        int max=0;
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
                
                if(max<h.get(arr[i]))
                {
                    max=h.get(arr[i]);
                     result=arr[i];
                    if(max>arr.length/4)
                    {
                        break;
                    }
                   
                }
            }
        
        
        return result;
        
        
    }
}
