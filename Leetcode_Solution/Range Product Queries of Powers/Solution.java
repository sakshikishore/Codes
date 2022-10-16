class Solution {
    public int[] productQueries(int n, int[][] queries) {
        String str=Integer.toBinaryString(n);
        int result[]=new int[queries.length];
        ArrayList<Integer> l=new ArrayList<Integer>();
        int j=0;
        for(int i=str.length()-1;i>=0;i--)
        {
             if(str.charAt(i)=='1')
             {
                 int x= (int)Math.pow(2,j);
                 l.add(x);
             }
            j++;
        }
        
        for(int i=0;i<queries.length;i++)
        {
            int x=queries[i][0];
            long res=l.get(x);
            int y=queries[i][1];
            for(int k=x+1;k<=y;k++)
            {
                res=(res*l.get(k))%(1000000007);
            }
            
            result[i]=(int)res;
        }
        
        return result;
    }
}
