class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count=0;
        HashSet<Integer> hSet=new HashSet<Integer>();
        HashSet<Integer> h1=new HashSet<Integer>();
        for(int i=0;i<reservedSeats.length;i++)
        {
            int x=(reservedSeats[i][0]*10)+reservedSeats[i][1];
            h1.add(reservedSeats[i][0]);
            hSet.add(x);
            
        }
        int p=n-h1.size();
        count=2*p;
        Iterator<Integer> itr=h1.iterator();
        while(itr.hasNext())
        {
           int i=itr.next();
           int a=i*10+2;
           int b=i*10+3;
           int c=i*10+4;
           int d=i*10+5;
           int e=i*10+6;
           int f=i*10+7;
           int g=i*10+8;
           int h=i*10+9;
            if(!hSet.contains(a) && !hSet.contains(b) && !hSet.contains(c) && !hSet.contains(d))
            {
                count++;
                if(!hSet.contains(e) && !hSet.contains(f) && !hSet.contains(g) && !hSet.contains(h))
                {
                    count++;
                }
            }
            else if(!hSet.contains(c) && !hSet.contains(d) && !hSet.contains(e) && !hSet.contains(f))
            {
                count++;
            }
            else if(!hSet.contains(e) && !hSet.contains(f) && !hSet.contains(g) && !hSet.contains(h))
            {
                count++;
            }
        }
        return count;
    }
}
