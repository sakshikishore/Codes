class Solution {
    public int[] beautifulArray(int n) {
        int result[]=new int[n];
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(1);
        for(int i=2;i<=n;i++)
        {
            ArrayList<Integer> m=new ArrayList<Integer>();
           for(int j=0;j<l.size();j++)
           {
               int x=(2*l.get(j))-1;
               if(x<=n)
               {
                   m.add(x);
               }
           }
          for(int j=0;j<l.size();j++)
           {
               int x=(2*l.get(j));
               if(x<=n)
               {
                   m.add(x);
               }
           }
          l=m;
        }
        for(int i=0;i<result.length;i++)
        {
            result[i]=l.get(i);
        }
        
        return result;
    }
}
