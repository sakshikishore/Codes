class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2==0 || k%5==0)
        {
            return -1;
        }
        int count=0;
        int r=0;
        HashSet<Integer> hset=new HashSet<Integer>();
       while(true)
       {
            count++;
            r=r*10+1;
            r=r%k;
            if(r==0)
            {
                return count;
            }
            if(hset.contains(r))
            {
                return -1;
            }

            hset.add(r);
       }

       
    }
}
