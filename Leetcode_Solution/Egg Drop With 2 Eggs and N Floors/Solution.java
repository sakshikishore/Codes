class Solution {
    public int twoEggDrop(int n) {
        int count=1;
        while(n>0)
        {
            n=n-count;
            if(n>0)
            {
                count++;
            }
            
        }
        
        return count;
        
    }
}
