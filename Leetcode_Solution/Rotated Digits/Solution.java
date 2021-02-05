 class Solution {
    public int rotatedDigits(int N) {
        int count=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(2);
        l.add(5);
        l.add(6);
        l.add(9);
        for(int i=2;i<=N;i++)
        {
            int p=i;
          int flag=1;
            while(p!=0)
            {
                int r=p%10;
                if(l.contains(r))
                {
                    flag=0;
                }
                else if(r==3 || r==4 || r==7)
                {
                    flag=1;
                    break;
                }
                p=p/10;
            }
            if(flag==0)
            {
                count++;
            }
        }
        
        return count;
    }
}
