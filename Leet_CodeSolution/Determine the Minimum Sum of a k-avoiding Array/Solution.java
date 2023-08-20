class Solution {
    public int minimumSum(int n, int k) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int result=0;
        int i=1;
        while(l.size()<n)
        {
            int flag=0;
            for(int j=0;j<l.size();j++)
            {
                if((l.get(j)+i)==k)
                {
                    i++;
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                l.add(i);
                result+=i;
                i++;
            }
             
        }
        
        return result;
        
    }
}
