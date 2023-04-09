class Solution {
    public int diagonalPrime(int[][] nums) {
        int i=0,j=0;
        int n=nums.length;
        int m=nums[0].length;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        HashSet<Integer> h=new HashSet<Integer>();
        while(i<n && j<m)
        {
            int r=nums[i][j];
            if(r==2 || r%2!=0)
            {
               if(!h.contains(r))
               {
                   h.add(r);
                   pq.add(r);
               }
            }
            i++;
            j++;
        }
        i=0;
        j=m-1;
        while(i<n && j>=0)
        {
            int r=nums[i][j];
            if(r==2 || r%2!=0)
            {
               if(!h.contains(r))
               {
                   h.add(r);
                   pq.add(r);
               }
            }
            i++;
            j--;
        }
        while(pq.size()>0)
        {
            int x=pq.poll();
            if(x!=1)
            {
                int flag=0;
                for(int k=2;k<=x/2;k++)
                {
                    if(x%k==0)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    return x;
                }
            }
            
        }
        
        return 0;
        
    }
}
