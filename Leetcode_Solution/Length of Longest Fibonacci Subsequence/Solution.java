class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> h=new HashSet<Integer>();
        int max=0;
         for(int i=0;i<arr.length;i++)
         {
             h.add(arr[i]);
         }
        for(int i=0;i<arr.length;i++)
        {
            if(arr.length-i<max)
            {
                break;
            }
            for(int j=i+1;j<arr.length;j++)
            {
                if((arr.length-j+i+1)<max)
                {
                    break;
                }
                int p=arr[i]+arr[j];
                int x=arr[j];
                int y=p;
                int count=2;
                while(h.contains(p))
                {
                    p=x+y;
                    x=y;
                    y=p;
                    count++;
                }
                if(count>max)
                {
                    max=count;
                }
            }
        }
        if(max==2)
        {
            max=0;
        }
        return max;
    }
}
