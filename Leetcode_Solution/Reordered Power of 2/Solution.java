class Solution {
    public boolean reorderedPowerOf2(int n) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        boolean result=false;
        while(n!=0)
        {
            int r=n%10;
            l.add(r);
            n=n/10;
        }
        Collections.sort(l);
        for(int i=0;i<32;i++)
        {
            ArrayList<Integer> m=new ArrayList<Integer>();
            int x=(int)Math.pow(2,i);
            while(x!=0)
            {
                int r=x%10;
                m.add(r);
                x=x/10;
            }
            Collections.sort(m);
            int flag=1;
            if(l.size()==m.size())
            {
                for(int j=0;j<l.size();j++)
                {
                    if(l.get(j)!=m.get(j))
                    {
                        flag=0;
                        break;
                    }
                }
                
                if(flag==1)
                {
                    result=true;
                    break;
                }
            }
        }
        
        return result;
        
    }
}
