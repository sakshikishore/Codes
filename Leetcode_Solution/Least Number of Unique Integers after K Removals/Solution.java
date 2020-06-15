class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        
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
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            l.add(entry.getValue());
        }
        
        Collections.sort(l);
        int p=0;
        int a=0,b=0;
        while(p!=k)
        {            
           p++;
           b++;
           if(l.get(a)==b)
            {
               a++;
               b=0;
            }
            
        }
       int sum=l.size()-a;
       
        
        
        return sum;
        
    }
}
