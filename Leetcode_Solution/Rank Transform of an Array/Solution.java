class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int a[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            a[i]=arr[i];
        }
        Arrays.sort(a);
        int rank=1;
        for(int i=0;i<a.length;i++)
        {
            if(!h.containsKey(a[i]))
            {
                h.put(a[i],rank);
                rank++;
            }
        }
        
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=h.get(arr[i]);
         
        }
        
        
        return arr;
    }
}
