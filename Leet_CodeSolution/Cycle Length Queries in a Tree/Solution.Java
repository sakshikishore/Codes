class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        int result[]=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int a=queries[i][0];
            int b=queries[i][1];
            ArrayList<Integer> l1=new ArrayList<Integer>();
            ArrayList<Integer> l2=new ArrayList<Integer>();
            if(h.containsKey(a))
            {
                 l1=h.get(a);
            }
            else
            {
                 l1=new ArrayList<Integer>();
                int x=a;
                while(x>=1)
                {
                    l1.add(x);
                    if(x==1)
                    {
                        break;
                    }
                    else
                    {
                       x=x/2;
                    }
                }

                h.put(a,l1);
            }

             if(h.containsKey(b))
            {
                 l2=h.get(b);
            }
            else
            {
                l2=new ArrayList<Integer>();
                int x=b;
                while(x>=1)
                {
                    l2.add(x);
                    if(x==1)
                    {
                        break;
                    }
                    else
                    {
                       x=x/2;
                    }
                }

                h.put(b,l2);
            }

            int p=l1.size()-1,q=l2.size()-1;
            while(p>=0 && q>=0 && (l1.get(p)-l2.get(q)==0))
            {
                p--;
                q--;
            }
            result[i]=p+q+3;
           
        }
        return result;
    }
}
