class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count=0;
        int i=0;
        while(tickets[k]!=0)
        {          
            if(tickets[i]!=0)
                {
                   tickets[i]=tickets[i]-1;
                   count++;
                }
            if(i==tickets.length-1)
            {
                i=0;
            }
            else
            {
                i++;
            }
             
        }
        
        return count;
    }
}
