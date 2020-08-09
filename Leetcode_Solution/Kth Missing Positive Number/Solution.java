class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++)
        {
            l.add(arr[i]);
        }
        int i=1;
        int count=0;
        int result=0;
        while(count<k)
        {
            if(!l.contains(i))
            {
                count++;
                if(count==k)
                {
                    result=i;
                    break;
                }
            }
            i++;
        }
        
        return result;
        
    }
}
