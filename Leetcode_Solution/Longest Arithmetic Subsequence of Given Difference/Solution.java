class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        h.put(arr[0],0);
        int result[]=new int[arr.length];
        result[0]=1;
        int max=1;
        for(int i=1;i<arr.length;i++)
        {
            result[i]=1;
            int x=arr[i]-difference;
            if(h.containsKey(x))
            {
                int index=h.get(x);
                result[i]=result[index]+1;
            }
            
            if(result[i]>max)
            {
                max=result[i];
            }
            h.put(arr[i],i);
        }
        
        return max;
    }
}
