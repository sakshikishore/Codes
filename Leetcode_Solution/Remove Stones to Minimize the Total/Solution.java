class Solution {
    public int minStoneSum(int[] piles, int k) {
     PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
     int sum=0;
     for(int i=0;i<piles.length;i++)
     {
         pq.add(piles[i]);
     }
     for(int i=0;i<k;i++)
     {
         int x=pq.poll();
         int p=x/2;
         x=x-p;
         pq.add(x);
     }
     while(pq.size()!=0)
     {
         sum+=pq.poll();
     }
        
        return sum;
    }
}
