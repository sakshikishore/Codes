class Solution {
    public int punishmentNumber(int n) {
        int result=1;
        for(int i=2;i<=n;i++)
        {
            int x=i*i;
            String str=Integer.toString(x);
            List<List<Integer>> list=new ArrayList();
            for(int j=0;j<str.length();j++)
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(Integer.parseInt(str.substring(0,j+1)));
                list.add(l);
                for(int k=j-1;k>=0;k--)
                {
                    int p=Integer.parseInt(str.substring(k+1,j+1));
                    for(int r=0;r<list.get(k).size();r++)
                    {
                        int q=list.get(k).get(r);
                        q=p+q;
                        list.get(j).add(q);
                    }

                }
            }
           int len=str.length()-1;
           for(int j=0;j<list.get(len).size();j++)
           {
               if(list.get(len).get(j)==i)
               {
                   result+=x;
                   break;
               }
           }
            
        }

        return result;
    }
}
