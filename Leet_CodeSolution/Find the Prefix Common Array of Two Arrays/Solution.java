class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
        int result[]=new int[A.length];
        for(int i=0;i<A.length;i++)
        {
            int count=0;
            if(!h1.containsKey(A[i]))
            {
                h1.put(A[i],1);
            }
            else
            {
                h1.put(A[i],h1.get(A[i])+1);
            }
            if(!h2.containsKey(B[i]))
            {
                h2.put(B[i],1);
            }
            else
            {
                h2.put(B[i],h2.get(B[i])+1);
            }
            for(Map.Entry<Integer,Integer> entry: h1.entrySet())
            {
                int key=entry.getKey();
                if(h2.containsKey(key))
                {
                    count+=Math.min(entry.getValue(),h2.get(key));
                }
            }
            result[i]=count;
        }
        
        return result;
        
    }
}
