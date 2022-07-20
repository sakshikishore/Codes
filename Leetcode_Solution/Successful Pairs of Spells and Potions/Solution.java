class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int result[]=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++)
        {
            int count=0;
            int start=0,end=potions.length-1;
            while(start<=end)
            {
                int mid=(start+end)/2;
                long p=1;
                long strength=p*potions[mid]*spells[i];
                if(strength>=success)
                {
                    count=count+(end-mid+1);
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
           
            result[i]=count;
        }
        
        return result;
    }
}
